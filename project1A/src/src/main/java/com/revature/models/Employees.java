package com.revature.models;

public class Employees implements Comparable<Employees>{

	private int employeeId;
	private int employeeNumber;
	private String username;
	private String password;
	private String name;
	
	
	public Employees(int employeeId, int employeeNumber, String username, String password, String name) {
		super();
		this.employeeId = employeeId;
		this.employeeNumber = employeeNumber;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public Employees(int employeeNumber, String username, String password, String name) {
		this(-1, employeeNumber, username, password, name);
		
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", employeeNumber=" + employeeNumber + ", username=" + username
				+ ", password=" + password + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employees o) {
		// TODO Auto-generated method stub
		
		
		if((this.employeeId == o.employeeId)&& (this.employeeNumber == o.employeeNumber)
		&&(this.username.equals(o.username))){
			return 0;
		}
		else if((this.employeeId > o.employeeId)&& (this.employeeNumber > o.employeeNumber)
				&&(this.username.compareTo(o.username) == 1)) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
	
	
	
	
}
