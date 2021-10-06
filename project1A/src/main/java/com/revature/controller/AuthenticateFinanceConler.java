package com.revature.controller;

import java.io.IOException;

import com.revature.models.Employees;
import com.revature.models.Finance;
import com.revature.service.EmployeeService;
import com.revature.service.FinanceService;

import io.javalin.http.Context;

public class AuthenticateFinanceConler {

	private FinanceService financeService;
	
	public AuthenticateFinanceConler(FinanceService financeService) {
		super();
		// TODO Auto-generated constructor stub
		
		this.financeService= financeService;
	}

	public void authenticate(Context ctx) {
		// TODO Auto-generated method stub
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		//System.out.println("username: "+ username);
		//System.out.println("password: "+ password );
		
		
		//console.log("Hello");
		
		Finance finance = this.financeService.loginFinance(username, password);
		
		
		//username and password		
		//boolean authenticated = authService.authenticate(username, password);
		
		if(finance != null) {
			
			
			
			ctx.sessionAttribute("user", finance);
			ctx.sessionAttribute("userType","Finance");
			
			
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
