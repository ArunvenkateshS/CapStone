package com.example.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.model.ExpenseDetail;

@Repository
public interface ExpenseDetailReopsitory extends JpaRepository<ExpenseDetail, Integer> {
	ExpenseDetail findByEmpId(long empId);
}
