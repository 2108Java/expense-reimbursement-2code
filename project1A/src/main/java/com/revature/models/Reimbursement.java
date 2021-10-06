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
	private String timeStamp;
	
	
	
	public Reimbursement(int reimbursementId, int reimbursementNumber, int employeeId, String reimbursementType,
			String approveStatus, double amount, String description, Timestamp timestamp) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementNumber = reimbursementNumber;
		this.employeeId = employeeId;
		this.reimbursementType = reimbursementType;
		this.approveStatus = approveStatus;
		this.amount = amount;
		this.description = description;
		this.timeStamp = timestamp.toString();
	}

	public Reimbursement(int reimbursementNumber, int employeeId, String reimbursementType,
			String approveStatus, double amount, String description, Timestamp timeStamp) {
		this(-1, reimbursementNumber, employeeId, reimbursementType,
				approveStatus, amount, description, timeStamp);
	}

	public int getReimbursementId() {
		return this.reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getRembursementNumber() {
		return this.reimbursementNumber;
	}

	public void setRembursementNumber(int reimbursementNumber) {
		this.reimbursementNumber = reimbursementNumber;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getReimursementType() {
		return this.reimbursementType;
	}

	public void setReimursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public String getApproveStatus() {
		return this.approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp.toString();
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementNumber=" + reimbursementNumber
				+ ", employeeId=" + employeeId + ", reimursementType=" + reimbursementType + ", approveStatus="
				+ approveStatus + ", amount=" + amount + ", description=" + description + ", timeStamp=" + timeStamp
				+ "]";
	}
	
	
}
