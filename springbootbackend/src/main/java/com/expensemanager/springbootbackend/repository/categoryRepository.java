package com.expensemanager.springbootbackend.repository;


import com.expensemanager.springbootbackend.model.expenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<expenseCategory, Long> {
    expenseCategory findByName(String name);
}
