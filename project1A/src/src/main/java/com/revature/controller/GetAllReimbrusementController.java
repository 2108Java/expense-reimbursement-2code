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
		return this.reimbursementService.getAllRequests();
	}
	public void setStatus(Context ctx) {
		// TODO Auto-generated method stub
		int reimbursementNumber = Integer.parseInt(ctx.formParam("reimbursementNumber"));
		String status = ctx.formParam("status");
		
		
		
		try {
			if(this.reimbursementService.changeStatusOfRequestRnumber(reimbursementNumber, status.toUpperCase())){
				ctx.res.setStatus(200);
				ctx.res.sendRedirect("/");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void makeRequest(Context ctx) {
		// TODO Auto-generated method stub
		
		
		
		int employeeNumber = Integer.parseInt(ctx.formParam("employeeNumber"));
		int rembursementNumber =new Random().nextInt(10000);
		String rembursementType = ctx.formParam("reimbursementType").toUpperCase();
		String approveStatus = "PENDING";
		double amount = Double.parseDouble(ctx.formParam("reimbursementAmount"));
		String description = ctx.formParam("reimbursementDescription");
		
		Reimbursement rq = new Reimbursement(-1, rembursementNumber, -1, rembursementType, approveStatus, amount, description, new Timestamp(0));
		
		
		
		
		
		try {
			if(this.reimbursementService.makeRequest(rq, employeeNumber)) {
				
				
				ctx.res.setStatus(200);
				ctx.res.sendRedirect("/");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
