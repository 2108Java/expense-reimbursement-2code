package com.revature.repo;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface DAOReimbursement {

	ArrayList<Reimbursement> selectAllEmployeeRequest(int employeeNumber);

	boolean insertRequest(Reimbursement reimbursment, int employeeNumber);

	ArrayList<Reimbursement> selectAllEmployeeRequest();

	
	boolean updateStatusByReimbursementNumber(int reimbursementNumber, String approveStatus);

	ArrayList<Reimbursement> selectAllByApproveStatus(int employeeNumber, String approveStatus);
	

	ArrayList<Reimbursement> selectAllByApproveStatus(String approveStatus);
}
