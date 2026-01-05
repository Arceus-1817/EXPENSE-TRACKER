package com.shreyansh.expensetracker.Expense.Tracker.API.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shreyansh.expensetracker.Expense.Tracker.API.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    // 🔥 IMPORTANT method (Day 4 requirement)
    List<Category> findByUserId(Long userId);
}
