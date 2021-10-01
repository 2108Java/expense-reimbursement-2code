package com.revature.repo;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface DAOReimbursement {

	ArrayList<Reimbursement> selectAllEmployeeRequest(int employeeNumber);

	boolean insertRequest(Reimbursement reimbursment, int employeeNumber);

	ArrayList<Reimbursement> selectAllEmployeeRequest();

	//ArrayList<Reimbursement> selectAllEmployeeRequestByNumber(int employeeNumber);

	//boolean updateStatusByEmployeeNumber(int employeeNumber, String approveStatus);

	boolean updateStatusByReimbursementNumber(int reimbursementNumber, String approveStatus);

	ArrayList<Reimbursement> selectAllByApproveStatus(int employeeNumber, String approveStatus);

}
