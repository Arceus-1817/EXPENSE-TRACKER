package com.shreyansh.expensetracker.Expense.Tracker.API.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shreyansh.expensetracker.Expense.Tracker.API.model.Category;
import com.shreyansh.expensetracker.Expense.Tracker.API.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/user/{userId}")
    public Category createCategory(
            @PathVariable Long userId,
            @RequestBody Category category
    ) {
        return categoryService.createCategory(category, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Category> getCategoriesByUser(@PathVariable Long userId) {
        return categoryService.getCategoriesByUser(userId);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
