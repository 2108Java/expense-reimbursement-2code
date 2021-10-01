package com.revature.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Reimbursement {

	private int reimbursementId;
	private int reimbursementNumber;
	private int employeeId;
	private String reimbursementType;
	private String approveStatus;
	private double amount;
	private String description;
	private Timestamp timeStamp;
	
	
	
	public Reimbursement(int reimbursementId, int rembursementNumber, int employeeId, String reimursementType,
			String approveStatus, double amount, String description, Timestamp timestamp) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementNumber = rembursementNumber;
		this.employeeId = employeeId;
		this.reimbursementType = reimursementType;
		this.approveStatus = approveStatus;
		this.amount = amount;
		this.description = description;
		this.timeStamp = timestamp;
	}
	
	public Reimbursement(int rembursementNumber, int employeeId, String reimursementType,
			String approveStatus, double amount, String description, Timestamp timeStamp) {
		this(-1, rembursementNumber, employeeId, reimursementType,
				approveStatus, amount, description, timeStamp);
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getRembursementNumber() {
		return reimbursementNumber;
	}

	public void setRembursementNumber(int rembursementNumber) {
		this.reimbursementNumber = rembursementNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getReimursementType() {
		return reimbursementType;
	}

	public void setReimursementType(String reimursementType) {
		this.reimbursementType = reimursementType;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", rembursementNumber=" + reimbursementNumber
				+ ", employeeId=" + employeeId + ", reimursementType=" + reimbursementType + ", approveStatus="
				+ approveStatus + ", amount=" + amount + ", description=" + description + ", timeStamp=" + timeStamp
				+ "]";
	}
	
	
}
