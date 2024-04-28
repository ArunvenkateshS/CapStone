package com.example.capstone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long expenseId;

private long empId;  

private String role;  

private String expenseType;  

private int amount;

private String reason;

private String status;

public Expense() {
	super();
}

public Expense(long expenseId, long empId, String role, String expenseType, int amount, String reason, String status) {
	super();
	this.expenseId = expenseId;
	this.empId = empId;
	this.role = role;
	this.expenseType = expenseType;
	this.amount = amount;
	this.reason = reason;
	this.status = status;
}

public long getExpenseId() {
	return expenseId;
}

public void setExpenseId(long expenseId) {
	this.expenseId = expenseId;
}

public long getEmpId() {
	return empId;
}

public void setEmpId(long empId) {
	this.empId = empId;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getExpenseType() {
	return expenseType;
}

public void setExpenseType(String expenseType) {
	this.expenseType = expenseType;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "Expense [expenseId=" + expenseId + ", empId=" + empId + ", role=" + role + ", expenseType=" + expenseType
			+ ", amount=" + amount + ", reason=" + reason + ", status=" + status + "]";
}


}