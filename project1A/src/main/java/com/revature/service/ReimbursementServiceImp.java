package com.revature.service;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.repo.DAOReimbursement;

public class ReimbursementServiceImp implements ReimbursementService {

	DAOReimbursement daoReimbursement;
	
	
	public ReimbursementServiceImp(DAOReimbursement daoReimbursement) {
		super();
		this.daoReimbursement = daoReimbursement;
	}

	@Override
	public ArrayList<Reimbursement> GetAllEmployeeRequest(int employeeNumber) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllEmployeeRequest(employeeNumber);
	}

	@Override
	public ArrayList<Reimbursement> GetAllRequests() {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllEmployeeRequest();
	}

	
	@Override
	public boolean ChangeStatusOfRequestRnumber(int reimbursementNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.updateStatusByReimbursementNumber(reimbursementNumber, approveStatus);
	}

	@Override
	public ArrayList<Reimbursement> GetAllRequestsByApproveStatus(int employeeNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllByApproveStatus(employeeNumber, approveStatus);
	}

	@Override
	public boolean MakeRequest(Reimbursement reimbursment, int employeeNumber) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.insertRequest(reimbursment, employeeNumber);
	}

	@Override
	public ArrayList<Reimbursement> GetAllRequestsByApproveStatus(String approveStatus) {
		// TODO Auto-generated method stub
		return this.daoReimbursement.selectAllByApproveStatus(approveStatus);
		
	}

}