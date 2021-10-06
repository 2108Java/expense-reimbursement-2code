package com.revature.service;

import com.revature.models.Employees;
import com.revature.repo.DAOEmployee;

public class EmployeeServiceImp implements EmployeeService {
	
	private DAOEmployee daoEmployee;
	
	public EmployeeServiceImp(DAOEmployee daoEmployee) {
		super();
		this.daoEmployee = daoEmployee;
	}

	@Override
	public Employees loginEmployee(String username, String password) {
		// TODO Auto-generated method stub
		
		
		return this.daoEmployee.selectEmployee(username, password);
	}

}
