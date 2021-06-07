package com.expensemanager.springbootbackend.controller;

import com.expensemanager.springbootbackend.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.expensemanager.springbootbackend.model.expenseCategory;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class categoryController {

    @Autowired
    private categoryRepository categoryRepo;

    @GetMapping("/categories")
    public Collection<expenseCategory> findAllCategories() {
        return categoryRepo.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Optional<expenseCategory> category = categoryRepo.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    public ResponseEntity<expenseCategory> createCategory(@Valid @RequestBody expenseCategory newCategory) throws URISyntaxException {
        expenseCategory category = categoryRepo.save(newCategory);
        return ResponseEntity.created(new URI("/api/category" + category.getId())).body(category);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<expenseCategory> updateCategory(@Valid @RequestBody expenseCategory updateCategory){
        expenseCategory category = categoryRepo.save(updateCategory);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
