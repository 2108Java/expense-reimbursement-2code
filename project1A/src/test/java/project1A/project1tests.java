package project1A;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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

public class project1tests {
	DAOEmployee daoEmployee;
	EmployeeService employeeService;
	
	DAOFinance daoFinance;
	FinanceService financeService;
	
	@Mock
	DAOReimbursement daoReimbursement;
	ReimbursementService reimbursementService;
	
	@Before
	public void setup() {
		
		daoEmployee = new DAOEmployeeImp();
		employeeService = new EmployeeServiceImp(daoEmployee);
		
		daoFinance = new DAOFinanceImp();
		financeService = new FinanceServiceImp(daoFinance);
		
		daoReimbursement = new DAOReimbursementImp();
		reimbursementService = new ReimbursementServiceImp(daoReimbursement);
		
		daoReimbursement = mock(DAOReimbursement.class);
		Reimbursement rem = new Reimbursement(-1,  new Random().nextInt(10000), -1, "FOOD", "PENDING", 100, "power outage", new Timestamp(0) );
		
		when(daoReimbursement.insertRequest(rem, 15674)).thenReturn(true);
		when(daoReimbursement.updateStatusByReimbursementNumber(63432, "APPROVED")).thenReturn(true);
		
		
	}
	@Test
	public void testMo() {
		
		//boolean makeRequest(Reimbursement reimbursment, int employeeNumber);
		//boolean changeStatusOfRequestRnumber(int reimbursementNumber, String approveStatus);
		
		Reimbursement rem = new Reimbursement(-1,  new Random().nextInt(10000), -1, "FOOD", "PENDING", 100, "power outage", new Timestamp(0) );
		
		
		
		assertTrue(reimbursementService.makeRequest(rem, 15674));
		assertTrue(reimbursementService.changeStatusOfRequestRnumber(63432, "APPROVED"));
		
		
		//mickto reimbursementService.MakeRequest(rem, 15674);
		//micekto reimbursementService.ChangeStatusOfRequestRnumber(63432, "APPROVED"); //reimbursement number
		
		
	}
	
	@Test
	public void testElogin() {
		
		//Employees(int employeeId, int employeeNumber, String username, String password, String name) {
			
		Employees e = new Employees(1,11342, "goodworker123","goodworker123","Good Worker" );
		
		assertEquals(0, e.compareTo(employeeService.loginEmployee(e.getUsername(), e.getPassword())));
		
		 e = new Employees(2,11342, "goodworker123","goodworker123","Good Worker" );
		assertEquals(-1, e.compareTo(employeeService.loginEmployee(e.getUsername(), e.getPassword())));
		
		e = new Employees(1,11842, "goodworker123","goodworker123","Good Worker" );
		assertEquals(-1, e.compareTo(employeeService.loginEmployee(e.getUsername(), e.getPassword())));
		
		
	}
	
	@Test
	public void testFlogin() {
		//(int financeManagerId, int financeNumber, String username, String password, String name) {
		
		Finance f = new Finance(1, 77905, "goodman123", "goodman123", "Good Man");
		
		assertEquals(0, f.compareTo(financeService.loginFinance(f.getUsername(), f.getPassword())));
	
		f = new Finance(2,77905, "goodman123","goodman123","Good Man" );
		assertEquals(-1, f.compareTo(financeService.loginFinance(f.getUsername(), f.getPassword())));
		
		f = new Finance(1,77005, "goodman123","goodman123","Good Man" );
		assertEquals(-1, f.compareTo(financeService.loginFinance(f.getUsername(), f.getPassword())));
		
	}

}
