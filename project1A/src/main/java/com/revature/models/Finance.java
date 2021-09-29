package com.revature.models;

public class Finance {

	private int financeManagerId;
	private int financeNumber;
	private String username;
	private String password;
	private String name;
	
	
	public Finance(int financeManagerId, int financeNumber, String username, String password, String name) {
		super();
		this.financeManagerId = financeManagerId;
		this.financeNumber = financeNumber;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public Finance(int financeNumber, String username, String password, String name) {
		this(-1, financeNumber, username, password, name);
	}

	public int getFinanceManagerId() {
		return financeManagerId;
	}

	public void setFinanceManagerId(int financeManagerId) {
		this.financeManagerId = financeManagerId;
	}

	public int getFinanceNumber() {
		return financeNumber;
	}

	public void setFinanceNumber(int financeNumber) {
		this.financeNumber = financeNumber;
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
		return "Finance [financeManagerId=" + financeManagerId + ", financeNumber=" + financeNumber + ", username="
				+ username + ", password=" + password + ", name=" + name + "]";
	}
	
	
	
	
}
