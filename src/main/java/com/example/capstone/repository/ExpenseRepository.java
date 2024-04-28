package com.example.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstone.model.Expense;



public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByStatus(String status); 
	List<Expense> findByEmpId(long empId);
}