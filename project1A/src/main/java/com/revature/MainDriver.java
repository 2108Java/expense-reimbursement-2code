package com.revature;

import com.revature.models.Employees;
import com.revature.models.Finance;
import com.revature.repo.DAOEmployee;
import com.revature.repo.DAOEmployeeImp;
import com.revature.repo.DAOFinance;
import com.revature.repo.DAOFinanceImp;
import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImp;
import com.revature.service.FinanceService;
import com.revature.service.FinanceServiceImp;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 
		 * BankDatabase  BankPGDatabase = new PostgreToDoDatabase();
		
		BankService bankService= new DAOBankService(BankPGDatabase);
		
		ConsoleBankAppImp BankApp= new ConsoleBankAppImp(bankService);
		
		BankApp.DisplayAndRunApp();
		 * 
		 * 
		*/
		
		DAOEmployee daoEmployee = new DAOEmployeeImp();
		EmployeeService employeeService = new EmployeeServiceImp(daoEmployee);
		
		Employees employee = employeeService.loginEmployee("goodworker123", "goodworker123");
		if(employee == null) {
			System.out.println("Employee not in database");
		}
		else {
			System.out.println("Employee: "+ employee.toString());
		}
		
		DAOFinance daoFinance = new DAOFinanceImp();
		FinanceService financeService = new FinanceServiceImp(daoFinance);
		
		Finance finance = financeService.loginFinance("goodman123", "goodman123");
		if(finance == null) {
			System.out.println("finance not in database");
		}
		else {
			System.out.println("Finance: "+ finance.toString());
		}
	}

}
