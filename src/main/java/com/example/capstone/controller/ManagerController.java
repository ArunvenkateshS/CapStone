package com.example.capstone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.capstone.model.Employee;
import com.example.capstone.model.Expense;
import com.example.capstone.model.ExpenseDetail;
import com.example.capstone.repository.EmployeeRepository;
import com.example.capstone.repository.ExpenseDetailReopsitory;
import com.example.capstone.repository.ExpenseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ManagerController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	ExpenseRepository expenseRepo;
	@Autowired
	ExpenseDetailReopsitory expenseDetailRepo;

	@GetMapping("employees")
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}
	
	@GetMapping("/expense/{empId}")
	public List<Expense> getexpense(@PathVariable("empId") long empId){
		return expenseRepo.findByEmpId(empId);
	}
	
	@GetMapping("/pending")
	public List<Expense> getpending(){
		return expenseRepo.findByStatus("pending");
	}
	
	@PutMapping("/expense/{expenseId}")
	public void putMethodName(@PathVariable("expenseId") long expenseId,@RequestBody Expense expense) {
		expenseRepo.save(expense);
	}
	
	@PutMapping("expensedetail/{empId}")
	public void putMethodName(@PathVariable("empId") long empId,@RequestBody ExpenseDetail expenseDetail) {
		expenseDetailRepo.save(expenseDetail);
	}
	
}
