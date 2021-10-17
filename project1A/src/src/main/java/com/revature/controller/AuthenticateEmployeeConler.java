package com.revature.controller;

import java.io.Console;
import java.io.IOException;

import com.revature.models.Employees;
import com.revature.service.EmployeeService;

import io.javalin.http.Context;

public class AuthenticateEmployeeConler {

	private EmployeeService employeeService;
	
	public AuthenticateEmployeeConler(EmployeeService employeeService) {
		super();
		// TODO Auto-generated constructor stub
		
		this.employeeService= employeeService;
	}

	public void authenticate(Context ctx) {
		// TODO Auto-generated method stub
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		
		
		Employees employee = this.employeeService.loginEmployee(username, password);
		
		
		
		if(employee != null) {
			
			
			ctx.sessionAttribute("user", employee);
			ctx.sessionAttribute("userType","Employees");
			
			
			
			try {
				ctx.res.setStatus(200);
				ctx.res.sendRedirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
			ctx.res.setStatus(401);
		}
				
	}

}
