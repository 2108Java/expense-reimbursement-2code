package com.revature.service;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementService {

	
	ArrayList<Reimbursement> GetAllEmployeeRequest(int employeeNumber);
	ArrayList<Reimbursement> GetAllRequests();
	//boolean ChangeStatusOfRequestEnumber(int employeeNumber, String approveStatus);
	boolean ChangeStatusOfRequestRnumber(int reimbursementNumber, String approveStatus);
	ArrayList<Reimbursement> GetAllRequestsByApproveStatus(int employeeNumber, String approveStatus);
	ArrayList<Reimbursement> GetAllRequestsByApproveStatus(String approveStatus);
	boolean MakeRequest(Reimbursement reimbursment, int employeeNumber);

}
