package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employees;
import com.revature.util.ConnectionFactory;

public class DAOEmployeeImp implements DAOEmployee {

	private ConnectionFactory connectionFactory;
	
	public DAOEmployeeImp() {
		super();
		
		connectionFactory = new ConnectionFactory();
	}

	@Override
	public Employees selectEmployee(String username, String password) {
		// TODO Auto-generated method stub
		
		Employees employee =null;
		
		try {
			Connection con = this.connectionFactory.getConnection();
			
			String sql ="SELECT * FROM employees WHERE employee_userName = ? AND employee_userPassword = ?;";
			PreparedStatement ps = con.prepareStatement(sql);


			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
				
				if((rs != null) &&(rs.next())) {
				
					employee= new Employees(rs.getInt("employee_id"), rs.getInt("employee_number"), 
						rs.getString("employee_userName"), rs.getString("employee_userPassword"), rs.getString("employee_name"));
				}
			
				
			
			rs.close();                         
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return employee;
	}

}
