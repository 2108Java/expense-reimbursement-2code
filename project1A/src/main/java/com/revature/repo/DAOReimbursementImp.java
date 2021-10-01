package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Employees;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class DAOReimbursementImp implements DAOReimbursement {

	ConnectionFactory connectionFactory;
	
	
	
	public DAOReimbursementImp() {
		super();
		connectionFactory = new ConnectionFactory();
	}

	@Override
	public ArrayList<Reimbursement> selectAllEmployeeRequest(int employeeNumber) {
		// TODO Auto-generated method stub
		ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
		
		try {
			Connection con = this.connectionFactory.getConnection();
	/*
	 * create table reimbursement(
	reimbursement_id serial primary key,
	reimbursement_number int unique not null,
	foreign_employees_key int references employees(employee_id),
	reimbursement_Type varchar(8),
	reimbursement_approveStatus varchar(10),
	reimbursement_amount real not null,
	reimbursement_description varchar(70),
	rTS timestamp NOT NULL DEFAULT NOW()
);		

public Reimbursement(int reimbursementId, int rembursementNumber, int employeeId, String reimursementType,
			String approveStatus, double amount, String description, String timeStamp)
*/
			
			String sql ="SELECT * FROM reimbursement WHERE foreign_employees_key = (SELECT employee_id FROM employees WHERE employee_number = ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, employeeNumber);
			
			ResultSet rs = ps.executeQuery();
			
			
				while((rs != null) &&(rs.next())) {
					
					Reimbursement reimbursement	= new Reimbursement(rs.getInt("reimbursement_id"), rs.getInt("reimbursement_number"), 
						rs.getInt("foreign_employees_key"), rs.getString("reimbursement_Type"), rs.getString("reimbursement_approveStatus"),
						rs.getDouble("reimbursement_amount"), rs.getString("reimbursement_description"), rs.getTimestamp("rTS") );
					reimbursementList.add(reimbursement);
				}
			
				//System.out.println(employee.toString());
			
			rs.close();                         
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return reimbursementList;
	}

	@Override
	public boolean insertRequest(Reimbursement reimbursment, int employeeNumber) {
		// TODO Auto-generated method stub
		boolean isinserted= false;
		try {
			Connection con = this.connectionFactory.getConnection();
	
			String sql = "INSERT INTO reimbursement(reimbursement_number, foreign_employees_key, reimbursement_Type, reimbursement_approveStatus, reimbursement_amount, reimbursement_description) VALUES\r\n"
					+ "(?, (select (employee_id) from employees where employee_number = ?), ?, ?, ?, ? );";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, reimbursment.getRembursementNumber()); //5
			ps.setInt(2, employeeNumber);
			ps.setString(3, reimbursment.getReimursementType());
			ps.setString(4, reimbursment.getApproveStatus());
			ps.setDouble(5, reimbursment.getAmount());			
			ps.setString(6, reimbursment.getDescription());
			
			ps.execute();
			
			
			ps.close();
			con.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isinserted= true;
		
		return isinserted;
	}

	@Override
	public ArrayList<Reimbursement> selectAllEmployeeRequest() {
		// TODO Auto-generated method stub
		
		ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
		
		try {
			Connection con = this.connectionFactory.getConnection();
	/*
	 * create table reimbursement(
	reimbursement_id serial primary key,
	reimbursement_number int unique not null,
	foreign_employees_key int references employees(employee_id),
	reimbursement_Type varchar(8),
	reimbursement_approveStatus varchar(10),
	reimbursement_amount real not null,
	reimbursement_description varchar(70),
	rTS timestamp NOT NULL DEFAULT NOW()
);		

public Reimbursement(int reimbursementId, int rembursementNumber, int employeeId, String reimursementType,
			String approveStatus, double amount, String description, String timeStamp)
*/
			
			String sql ="SELECT * FROM reimbursement";
			PreparedStatement ps = con.prepareStatement(sql);

			
			ResultSet rs = ps.executeQuery();
			
			
				while((rs!= null)&&(rs.next())) {
					
					Reimbursement reimbursement	= new Reimbursement(rs.getInt("reimbursement_id"), rs.getInt("reimbursement_number"), 
						rs.getInt("foreign_employees_key"), rs.getString("reimbursement_Type"), rs.getString("reimbursement_approveStatus"),
						rs.getDouble("reimbursement_amount"), rs.getString("reimbursement_description"), rs.getTimestamp("rTS") );
					
					reimbursementList.add(reimbursement);
				}
			
				
			rs.close();                         
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return reimbursementList;
	}


	@Override
	public boolean updateStatusByReimbursementNumber(int reimbursementNumber, String approveStatus) {
		// TODO Auto-generated method stub
		boolean isupdated= false;
		
		try {
			Connection con = this.connectionFactory.getConnection();
			
			String sql = "UPDATE reimbursement SET reimbursement_approveStatus = ? WHERE reimbursement_number = ?;	";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, approveStatus);
			ps.setInt(2, reimbursementNumber);
	
			
			ps.execute();
			
			
			ps.close();
			con.close();	
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		isupdated= true;
		
		return isupdated;
	}

	

	@Override
	public ArrayList<Reimbursement> selectAllByApproveStatus(int employeeNumber, String approveStatus) {
		// TODO Auto-generated method stub
ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
		
		try {
			Connection con = this.connectionFactory.getConnection();
	/*
	 * create table reimbursement(
	reimbursement_id serial primary key,
	reimbursement_number int unique not null,
	foreign_employees_key int references employees(employee_id),
	reimbursement_Type varchar(8),
	reimbursement_approveStatus varchar(10),
	reimbursement_amount real not null,
	reimbursement_description varchar(70),
	rTS timestamp NOT NULL DEFAULT NOW()
);		

public Reimbursement(int reimbursementId, int rembursementNumber, int employeeId, String reimursementType,
			String approveStatus, double amount, String description, String timeStamp)
*/
			
			String sql ="SELECT * FROM reimbursement WHERE reimbursement_approveStatus= ? AND foreign_employees_key = (SELECT employee_id FROM employees WHERE employee_number = ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, approveStatus);
			ps.setInt(2, employeeNumber);
			
			
			ResultSet rs = ps.executeQuery();
			
			
				while((rs != null) &&(rs.next())) {
					
					Reimbursement reimbursement	= new Reimbursement(rs.getInt("reimbursement_id"), rs.getInt("reimbursement_number"), 
						rs.getInt("foreign_employees_key"), rs.getString("reimbursement_Type"), rs.getString("reimbursement_approveStatus"),
						rs.getDouble("reimbursement_amount"), rs.getString("reimbursement_description"), rs.getTimestamp("rTS") );
					reimbursementList.add(reimbursement);
				}
			
				//System.out.println(employee.toString());
			
			rs.close();                         
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return reimbursementList;

	}

}
