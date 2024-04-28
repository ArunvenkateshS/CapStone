package com.example.capstone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExpenseDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long empId;
	private int medical;
	private int travel;
	private int internet;
	public ExpenseDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseDetail(int id, long empId, int medical, int travel, int internet) {
		super();
		this.id = id;
		this.empId = empId;
		this.medical = medical;
		this.travel = travel;
		this.internet = internet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public int getMedical() {
		return medical;
	}
	public void setMedical(int medical) {
		this.medical = medical;
	}
	public int getTravel() {
		return travel;
	}
	public void setTravel(int travel) {
		this.travel = travel;
	}
	public int getInternet() {
		return internet;
	}
	public void setInternet(int internet) {
		this.internet = internet;
	}
	@Override
	public String toString() {
		return "ExpenseDetail [id=" + id + ", empId=" + empId + ", medical=" + medical + ", travel=" + travel
				+ ", internet=" + internet + "]";
	}
	
	
	
	
	
}
