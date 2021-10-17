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
		
		
		
		Finance finance = this.financeService.loginFinance(username, password);
		
		
	
		
		if(finance != null) {
			
			
			
			ctx.sessionAttribute("user", finance);
			ctx.sessionAttribute("userType","Finance");
			
			
			
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
