package com.expensemanager.springbootbackend.controller;

import com.expensemanager.springbootbackend.model.Expense;
import com.expensemanager.springbootbackend.repository.expenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class expenseController {

    @Autowired
    private expenseRepository expenseRepo;

    @GetMapping("/expenses")
    List<Expense> getExpenses(){
        return expenseRepo.findAll();
    }

    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id){
        expenseRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/expenses")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense newExpense) throws URISyntaxException {
        Expense ex = expenseRepo.save(newExpense);
        return ResponseEntity.created(new URI("/api/expenses" + ex.getId())).body(ex);
    }
}
