package com.revature;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

import com.revature.models.Employees;
import com.revature.models.Finance;
import com.revature.models.Reimbursement;
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

public class MainDriver {

private static void printList(List list) {
		
		for(int x =0; x< list.size(); x++) {
			
			
			if(list.get(x) != null) {
				System.out.println(list.get(x).toString() );
			
			}
		}
		
	}
	
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
		
		DAOReimbursement daoReimbursement = new DAOReimbursementImp();
		ReimbursementService reimbursementService = new ReimbursementServiceImp(daoReimbursement);
		
		List list = reimbursementService.GetAllRequests();
		//System.out.println("size: "+list.size());
		printList(list);
		
		System.out.println("listB: ");
		
		list = reimbursementService.GetAllEmployeeRequest(11342);
		//System.out.println("size: "+list.size());
		printList(list);
		
		list = reimbursementService.GetAllRequestsByApproveStatus(11342, "PENDING");
		System.out.println("listC: ");
		printList(list);
		
		reimbursementService.ChangeStatusOfRequestRnumber(63432, "APPROVED");
		
		list = reimbursementService.GetAllRequests();
		System.out.println("listD: ");
		printList(list);
		
		Reimbursement rem = new Reimbursement(-1,  new Random().nextInt(10000), -1, "FOOD", "PENDING", 100, "power outage", new Timestamp(0) );
		
		reimbursementService.MakeRequest(rem, 15674);
		
		list = reimbursementService.GetAllRequests();
		System.out.println("listE: ");
		printList(list);
	}

}
