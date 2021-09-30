package com.revature.repo;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class DAOReimbursementImp implements DAOReimbursement {

	ConnectionFactory connectionFactory;
	
	@Override
	public ArrayList<Reimbursement> selectAllEmployeeRequest(int employeeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRequest(Reimbursement reimbursment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reimbursement> selectAllEmployeeRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> selectAllEmployeeRequestByNumber(int employeeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStatusByEmployeeNumber(int employeeNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStatusByReimbursementNumber(int reimbursementNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reimbursement> selectAllByApproveStatus(int employeeNumber, String approveStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
