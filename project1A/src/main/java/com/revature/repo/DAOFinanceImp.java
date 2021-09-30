package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employees;
import com.revature.models.Finance;
import com.revature.util.ConnectionFactory;

public class DAOFinanceImp implements DAOFinance {

	ConnectionFactory connectionFactory;
	
	@Override
	public Finance selectFinance(String username, String password) {
		// TODO Auto-generated method stub
		Finance finance = null;
		
		try {
			Connection con = this.connectionFactory.getConnection();
			
			String sql ="SELECT * FROM finance WHERE finance_userName = ? AND finance_userPassword = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

//			ps.setString(1, add.getTitle());
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			//rs.next();
			
//			BankCustomer(int id, String userName, String password, int customerNumber, String firstName, String lastName) {
				
				/*
				 * public Finance(int financeManagerId, int financeNumber, String username, String password, String name)
				 *
				 * create table finance (
	finance_id serial primary key, --primary key 
	finance_userName varchar(20) unique,
	finance_userPassword varchar(20) not null,
	finance_number int unique not null,
	finance_name varchar(20)
	);

				 * * */
				
				if((rs != null) &&(rs.next())) {
				
					finance= new Finance(rs.getInt("finance_id"), rs.getInt("finance_number"), 
						rs.getString("finance_userName"), rs.getString("finance_userPassword"), rs.getString("finance_name"));
				}
			
			
			rs.close();                         
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return finance;
	}

}
