package com.revature.controller;

import java.util.Random;
import java.lang.*;

import com.revature.models.Employees;
import com.revature.models.Finance;
import com.revature.repo.DAOEmployee;
import com.revature.repo.DAOEmployeeImp;
import com.revature.repo.DAOFinance;
import com.revature.repo.DAOFinanceImp;
import com.revature.repo.DAOReimbursement;
import com.revature.repo.DAOReimbursementImp;
import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImp;
import com.revature.service.FinanceService;
import com.revature.service.FinanceServiceImp;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementServiceImp;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class RequestMappings {

	
	
	public static boolean checkSession(Context ctx) {
		if(ctx.sessionAttribute("user") != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void setupEndPoints(Javalin app) {
		
		
		DAOEmployee daoEmployee = new DAOEmployeeImp();
		EmployeeService employeeService = new EmployeeServiceImp(daoEmployee);
		
		AuthenticateEmployeeConler aEcontroller = new AuthenticateEmployeeConler(employeeService);
		
		DAOReimbursement daoReimbursement = new DAOReimbursementImp();
		ReimbursementService reimbursementService = new ReimbursementServiceImp(daoReimbursement);
		
		GetAllEmployeeReimbrusementController gAEREmController = 
				new GetAllEmployeeReimbrusementController(reimbursementService);
		
		
		DAOFinance daoFinance = new DAOFinanceImp();
		FinanceService financeService = new FinanceServiceImp(daoFinance);
		
		AuthenticateFinanceConler aFcontroller = new AuthenticateFinanceConler(financeService);
		
		GetAllReimbrusementController gAREmController = 
				new GetAllReimbrusementController(reimbursementService);
		
		
			app.get("/", ctx -> {
			
			
			if(checkSession(ctx)) {
				if(ctx.sessionAttribute("userType").equals("Employees")) {
					ctx.req.getRequestDispatcher("/employeeHomePage").forward(ctx.req, ctx.res);
				}
				
				if(ctx.sessionAttribute("userType").equals("Finance")) {
					ctx.req.getRequestDispatcher("/financeHomePage").forward(ctx.req, ctx.res);
				}
			}
			else {
				
				ctx.req.getRequestDispatcher("Welcome_login_page.html").forward(ctx.req, ctx.res);
			}
				
			
		}
			);
		
		app.get("/employeeHomePage", ctx->{
			if(checkSession(ctx)) {
				ctx.req.getRequestDispatcher("Employee_Page.html").forward(ctx.req, ctx.res);
			}
			else {
				ctx.res.sendRedirect("/");
			}
		});
		
		
		app.get("/financeHomePage", ctx -> {
			
			
			if(checkSession(ctx)) {
				ctx.req.getRequestDispatcher("Finance_Page.html").forward(ctx.req, ctx.res);	
			}
			else {
				ctx.res.sendRedirect("/");
			}
				
			
		}
			);
		
		
		
		
		app.post("/authenticateEmployee", ctx -> {
			
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			
			if(!username.isBlank() && !password.isBlank()) {
				aEcontroller.authenticate(ctx);
			}
			else {
				ctx.redirect("/");
			}
			
			
			
			
		});
		
		app.post("/reimbursementRequest", ctx -> {
			
		
			
			if(checkSession(ctx)){
				
				if(!(ctx.formParam("employeeNumber").isBlank()) &&(!(ctx.formParam("reimbursementAmount").isBlank() )&& (!ctx.formParam("reimbursementType").isBlank()))) {
					
					gAREmController.makeRequest(ctx);
				}
				else {
					ctx.redirect("/");
				}
				
			}
			else {
				ctx.status(400);
			}
			
		});
		
		app.post("/authenticateFinance", ctx -> {
			
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			
			if(!username.isBlank() && !password.isBlank()) {
				aFcontroller.authenticate(ctx);
			}
			else {
				ctx.redirect("/");
			}
			
		});
		
		app.get("/invalidateSession", ctx -> {
			
		ctx.consumeSessionAttribute("user");
		ctx.consumeSessionAttribute("userType");
		
		ctx.redirect("/");
		});
		
		app.get("/finance", ctx -> {
			
			
			if(checkSession(ctx)){
			ctx.json(ctx.sessionAttribute("user"));
		}else {
			ctx.status(400);
		}
		
		});
		
		app.get("/employee", ctx -> {
			
			if(checkSession(ctx)){
			ctx.json(ctx.sessionAttribute("user"));
		}else {
			ctx.status(400);
		}
		
		});
		
		app.get("/getAllEmployeeReimbursement", ctx -> {
					
					if(checkSession(ctx)){
					ctx.json(gAEREmController.getAll(((Employees) ctx.sessionAttribute("user")).getEmployeeNumber()));
				}
				else {
					ctx.status(400);
				}
				
				});
		app.get("/getAllReimbursements", ctx -> {
			
			if(checkSession(ctx)){
			ctx.json(gAREmController.getAll());
		}
		else {
			ctx.status(400);
		}
		
		});
		
		app.post("/setStatus", ctx -> {
			
			if(checkSession(ctx)){
				
				
				String status = ctx.formParam("status");
				
				if(!ctx.formParam("reimbursementNumber").isBlank() && !status.isBlank()) {
					gAREmController.setStatus(ctx);
				}else {
					ctx.redirect("/");
				}
				
				
			}
			else {
				ctx.status(400);
			}
		
		});		
		
		
	}
	
}
