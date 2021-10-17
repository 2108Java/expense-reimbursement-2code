package com.revature.repo;

import com.revature.models.Employees;

public interface DAOEmployee {

	Employees selectEmployee(String username, String password);

}
