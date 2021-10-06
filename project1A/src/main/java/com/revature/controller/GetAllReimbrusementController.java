package com.revature.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;

import io.javalin.http.Context;

public class GetAllReimbrusementController {

	
private ReimbursementService reimbursementService;
	
	
	public GetAllReimbrusementController(ReimbursementService reimbursementService) {
		// TODO Auto-generated constructor stub
		
		this.reimbursementService = reimbursementService;
		//this.employeesNumber = employeesNumber;
	}
	public ArrayList<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return this.reimbursementService.GetAllRequests();
	}
	public void setStatus(Context ctx) {
		// TODO Auto-generated method stub
		int reimbursementNumber = Integer.parseInt(ctx.formParam("reimbursementNumber"));
		String status = ctx.formParam("status");
		
		//System.out.println("reimbursementNumber: "+ reimbursementNumber);
		//System.out.println("status: "+ status );
		
		this.reimbursementService.ChangeStatusOfRequestRnumber(reimbursementNumber, status.toUpperCase());
		
		
		try {
			ctx.res.sendRedirect("http://localhost:7001/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void makeRequest(Context ctx) {
		// TODO Auto-generated method stub
		
		/*
		 * 
            private int reimbursementId;
	private int reimbursementNumber;
	private int employeeId;
	private String reimbursementType;
	private String approveStatus;
	private double amount;
	private String description;
	private String timeStamp;
		
		
		ps.setInt(1, reimbursment.getRembursementNumber()); //5
		ps.setInt(2, employeeNumber);
		ps.setString(3, reimbursment.getReimursementType());
		ps.setString(4, reimbursment.getApproveStatus());
		ps.setDouble(5, reimbursment.getAmount());			
		ps.setString(6, reimbursment.getDescription());
		
		Reimbursement(int reimbursementId, int reimbursementNumber, int employeeId, String reimbursementType,
				String approveStatus, double amount, String description, Timestamp timestamp)
		*/
		
		int employeeNumber = Integer.parseInt(ctx.formParam("employeeNumber"));
		int rembursementNumber =new Random().nextInt(10000);
		String rembursementType = ctx.formParam("reimbursementType").toUpperCase();
		String approveStatus = "PENDING";
		double amount = Double.parseDouble(ctx.formParam("reimbursementAmount"));
		String description = ctx.formParam("reimbursementDescription");
		
		Reimbursement rq = new Reimbursement(-1, rembursementNumber, -1, rembursementType, approveStatus, amount, description, new Timestamp(0));
		
		
		
		this.reimbursementService.MakeRequest(rq, employeeNumber);
		
		try {
			ctx.res.sendRedirect("http://localhost:7001/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
