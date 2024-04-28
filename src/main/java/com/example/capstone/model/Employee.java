package com.example.capstone.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long empId;

private String empName;  

private String password;  

private String role;  

private String email;  


@Override
public String toString() {
	return "Employee [empid=" + empId + ", empName=" + empName + ", password=" + password + ", role=" + role
			+ ", email=" + email + "]";
}



public Employee() {
	super();
}



public Employee(long empid, String empName, String password, String role, String email) {
	super();
	this.empId = empid;
	this.empName = empName;
	this.password = password;
	this.role = role;
	this.email = email;
}



public long getEmpid() {
	return empId;
}



public void setEmpid(long empid) {
	this.empId = empid;
}



public String getEmpName() {
	return empName;
}



public void setEmpName(String empName) {
	this.empName = empName;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getRole() {
	return role;
}



public void setRole(String role) {
	this.role = role;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}




	

}