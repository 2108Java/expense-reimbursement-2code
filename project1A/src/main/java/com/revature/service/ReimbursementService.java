package com.revature.service;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementService {

	
	ArrayList<Reimbursement> getAllEmployeeRequest(int employeeNumber);
	ArrayList<Reimbursement> getAllRequests();
	//boolean ChangeStatusOfRequestEnumber(int employeeNumber, String approveStatus);
	boolean changeStatusOfRequestRnumber(int reimbursementNumber, String approveStatus);
	ArrayList<Reimbursement> getAllRequestsByApproveStatus(int employeeNumber, String approveStatus);
	ArrayList<Reimbursement> getAllRequestsByApproveStatus(String approveStatus);
	boolean makeRequest(Reimbursement reimbursment, int employeeNumber);

}
