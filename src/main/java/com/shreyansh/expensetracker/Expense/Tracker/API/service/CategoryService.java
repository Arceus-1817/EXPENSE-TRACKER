package com.shreyansh.expensetracker.Expense.Tracker.API.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shreyansh.expensetracker.Expense.Tracker.API.model.Category;
import com.shreyansh.expensetracker.Expense.Tracker.API.model.User;
import com.shreyansh.expensetracker.Expense.Tracker.API.repo.CategoryRepo;
import com.shreyansh.expensetracker.Expense.Tracker.API.repo.UserRepo;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;

    public CategoryService(CategoryRepo categoryRepo, UserRepo userRepo) {
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
    }

    public Category createCategory(Category category, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        category.setUser(user);
        return categoryRepo.save(category);
    }

    public List<Category> getCategoriesByUser(Long userId) {
        return categoryRepo.findByUserId(userId);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public void deleteCategory(Long categoryId) {
        categoryRepo.deleteById(categoryId);
    }
}
