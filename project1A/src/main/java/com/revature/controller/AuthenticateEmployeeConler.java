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
		
		//System.out.println("username: "+ username);
		//System.out.println("password: "+ password );
		
		
		//console.log("Hello");
		
		Employees employee = this.employeeService.loginEmployee(username, password);
		
		
		
		if(employee != null) {
			
			
			ctx.sessionAttribute("user", employee);
			ctx.sessionAttribute("userType","Employees");
			
			
			//When you want to turn back into a GET request
			//Ask the client to send another request, 
			//The client will send the request through the search bar
			//The search bar is by definition a GET request. 
//			ctx.res.sendRedirect("http://localhost:8000/home");
			try {
				ctx.res.sendRedirect("http://localhost:7001/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
			ctx.res.setStatus(401);
		}
				
	}

}
