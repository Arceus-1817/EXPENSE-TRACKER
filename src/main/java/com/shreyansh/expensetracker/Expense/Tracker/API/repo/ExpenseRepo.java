package com.shreyansh.expensetracker.Expense.Tracker.API.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shreyansh.expensetracker.Expense.Tracker.API.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>, JpaSpecificationExecutor<Expense>{

    // Page<Expense> findByUserId(Long userId, Pageable pageable);

    // Page<Expense> findByCategoryId(Long categoryId ,Pageable pageable);

    // @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
    // Double sumExpensesByUserId(@Param("userId") Long userId);
}
