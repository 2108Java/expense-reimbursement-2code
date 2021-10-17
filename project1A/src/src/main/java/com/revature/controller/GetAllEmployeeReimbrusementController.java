package com.revature.controller;

import java.util.ArrayList;

import com.revature.models.Employees;
import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;

public class GetAllEmployeeReimbrusementController {

	private ReimbursementService reimbursementService;
	
	
	public GetAllEmployeeReimbrusementController(ReimbursementService reimbursementService) {
		// TODO Auto-generated constructor stub
		
		this.reimbursementService = reimbursementService;
		//this.employeesNumber = employeesNumber;
	}
	public ArrayList<Reimbursement> getAll(int employeeNumber) {
		// TODO Auto-generated method stub
		return this.reimbursementService.getAllEmployeeRequest(employeeNumber);
	}

}
