package com.shreyansh.expensetracker.Expense.Tracker.API.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shreyansh.expensetracker.Expense.Tracker.API.model.Expense;
import com.shreyansh.expensetracker.Expense.Tracker.API.repo.ExpenseRepo;
import com.shreyansh.expensetracker.Expense.Tracker.API.repo.ExpenseSpecification;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public Expense createExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    public Page<Expense> filterExpenses(
            Long userId,
            Long categoryId,
            Double minAmount,
            Double maxAmount,
            LocalDate startDate,
            LocalDate endDate,
            Pageable pageable) {

        Specification<Expense> spec =
                Specification.where(ExpenseSpecification.userId(userId));

        if (categoryId != null) {
            spec = spec.and(ExpenseSpecification.categoryId(categoryId));
        }

        spec = spec
                .and(ExpenseSpecification.amountBetween(minAmount, maxAmount))
                .and(ExpenseSpecification.dateBetween(startDate, endDate));

        return expenseRepo.findAll(spec, pageable);
    }

    public void deleteExpense(Long id) {
        expenseRepo.deleteById(id);
    }
}
