package com.revature.service;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.repo.DAOReimbursement;

public class ReimbursementServiceImp implements ReimbursementService {

	private DAOReimbursement daoReimbursement;
	
	
	public ReimbursementServiceImp(DAOReimbursement daoReimbursement) {
		super();
		this.daoReimbursement = daoReimbursement;
	}

	@Override
	public ArrayList<Reimbursement> getAllEmployeeRequest(int employeeNumber) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllEmployeeRequest(employeeNumber);
	}

	@Override
	public ArrayList<Reimbursement> getAllRequests() {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllEmployeeRequest();
	}

	
	@Override
	public boolean changeStatusOfRequestRnumber(int reimbursementNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.updateStatusByReimbursementNumber(reimbursementNumber, approveStatus);
	}

	@Override
	public ArrayList<Reimbursement> getAllRequestsByApproveStatus(int employeeNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllByApproveStatus(employeeNumber, approveStatus);
	}

	@Override
	public boolean makeRequest(Reimbursement reimbursment, int employeeNumber) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.insertRequest(reimbursment, employeeNumber);
	}

	@Override
	public ArrayList<Reimbursement> getAllRequestsByApproveStatus(String approveStatus) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllByApproveStatus(approveStatus);
		
	}

}
