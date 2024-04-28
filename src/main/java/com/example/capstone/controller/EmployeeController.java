package com.example.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstone.error.ResourceNotFoundException;
import com.example.capstone.model.Employee;
import com.example.capstone.model.Expense;
import com.example.capstone.model.ExpenseDetail;
import com.example.capstone.repository.EmployeeRepository;
import com.example.capstone.repository.ExpenseDetailReopsitory;
import com.example.capstone.repository.ExpenseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	ExpenseRepository expenseRepo;
	@Autowired
	ExpenseDetailReopsitory expenseDetailRepo;
	

	@PostMapping("/signup")
	public void postSignUp(@RequestBody Employee emp) {
		employeeRepo.save(emp);
		Employee currentEmp = employeeRepo.findByEmail(emp.getEmail());
		expenseDetailRepo.save(new ExpenseDetail(0,currentEmp.getEmpid(),50000,5000,2000));
		}
		
	@PostMapping("/login")	
	public Employee checkValidation(@RequestBody List<String> credential){
		String mailId = credential.get(0);
		String pass = credential.get(1);
		Employee employee = employeeRepo.findByEmailAndPassword(mailId, pass);
		if(employee == null)
			throw new ResourceNotFoundException("No User registered");
		else 
			return employee;
	}
	 
	@GetMapping("/expensedetail/{empId}")
	public ExpenseDetail getMethodName(@PathVariable("empId") long empId) {
		return expenseDetailRepo.findByEmpId(empId);	
	}
	
	@PostMapping("/postall")
	public Expense postSignUp(@RequestBody Expense exp) {
		expenseRepo.save(exp);
		return exp;
	}
	
	 @PostMapping("/api/expenses")
    public ResponseEntity<String> createExpense(@RequestBody Expense expense) {
        try {
            long employeeId = expense.getEmpId();
           
            ExpenseDetail expenseDetails = expenseDetailRepo.findByEmpId(employeeId);
            
            switch (expense.getExpenseType()) {
                case "medical":
                    expenseDetails.setMedical(expenseDetails.getMedical() - expense.getAmount());
                    break;
                case "travel":
                    expenseDetails.setTravel(expenseDetails.getTravel() - expense.getAmount());
                    break;
                case "internet":
                    expenseDetails.setInternet(expenseDetails.getInternet() - expense.getAmount());
                    break;
                default:
                    
                    return ResponseEntity.badRequest().body("Invalid expense type");
            }
  
            expenseDetailRepo.save(expenseDetails);

            return ResponseEntity.ok("Expense created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create expense");
        }
    }
	
}
