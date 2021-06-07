package com.expensemanager.springbootbackend.repository;

import com.expensemanager.springbootbackend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface expenseRepository extends JpaRepository<Expense, Long> {
}
