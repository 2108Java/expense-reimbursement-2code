package com.revature.service;

import com.revature.models.Employees;

public interface EmployeeService {

	Employees loginEmployee(String username, String password);
	
}
