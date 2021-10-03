package com.revature.controller;

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
		//UserDao uDao = new UserDaoImpl();
		//BookDao bDao = new BookDaoImpl();
		//BookLoanDao loanDao = new BookLoanDaoImpl();
		   
		//UserService userService = new UserServiceImpl(uDao, bDao, loanDao);
		//AuthenticateService authService = new AuthenticateServiceImpl(uDao);
		
		//AuthenticateController ac = new AuthenticateController(authService, userService);
		
		//Start setting up my view logic!
		
		//The first thing the user is going to see is the login page!
		
		app.get("/financeHomePage", ctx -> {
			
			
			if(checkSession(ctx)) {
				//fc.DisplayHomePage(ctx);				
			}
			else {
				ctx.res.sendRedirect("http://localhost:8000/");
			}
				
			
		}
			);
		
		
		app.get("/employeeHomePage", ctx -> {
			
			
			if(checkSession(ctx)) {
				//ec.DisplayHomePage(ctx);				
			}
			else {
				ctx.res.sendRedirect("http://localhost:8000/");
			}
				
			
		}
			);
		
		
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
				//ctx.res.sendRedirect("http://localhost:8000/");
				ctx.req.getRequestDispatcher("Login.html").forward(ctx.req, ctx.res);
			}
				
			
		}
			);
		
		
		//app.get("/", 
		//		ctx -> 
		//			ctx.req.getRequestDispatcher("Login.html").forward(ctx.req, ctx.res)
		//		);
		/*
		//LandingPage 
		app.get("/home", ctx -> 
		{
			if(checkSession(ctx)) {
				ctx.req.getRequestDispatcher("LandingLibrary.html").forward(ctx.req, ctx.res);
			}else {
				ctx.res.sendRedirect("http://localhost:8000/");
			}
		
		
		});
	*/
		
		
		//Authentication Controller!
		//This is going to be my endpoints for authenticating a user! 
		app.post("/authenticateEmployee", ctx -> {
			
			//ac.authenticateUser(ctx);
			
		});
		
		app.post("/authenticateFinance", ctx -> {
			
			//ac.authenticateUser(ctx);
			
		});
		
		app.post("/invalidateSession", ctx -> {
			
		ctx.consumeSessionAttribute("user");
		ctx.consumeSessionAttribute("userType");
		
		ctx.redirect("http://localhost:8000/");
		});
		
		
		
		//User Controller
		//That returns all the user details! 
		
		//We will be using AJAX to communicate to this end point 
		//Where we get the user object 
		//We render the user's information to us, e.g. their books!
		app.get("/user", ctx -> {
			
			if(checkSession(ctx)){
				ctx.json(ctx.sessionAttribute("user"));
			}else {
				ctx.status(400);
			}
			
		});
		
		//app.get("/allAvailableBooks", null);
		
		
		//app.put("/updateUsersBook", null); //checkout and return books
		
		
	}
	
}
