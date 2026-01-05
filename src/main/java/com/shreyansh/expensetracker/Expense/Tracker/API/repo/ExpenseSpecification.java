package com.shreyansh.expensetracker.Expense.Tracker.API.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.shreyansh.expensetracker.Expense.Tracker.API.model.Expense;

public class ExpenseSpecification {

    public static Specification<Expense> userId(Long userId) {
        return (root, query, cb) ->
                cb.equal(root.get("user").get("id"), userId);
    }

    public static Specification<Expense> categoryId(Long categoryId) {
        return (root, query, cb) ->
                cb.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Expense> amountBetween(
            Double min, Double max) {

        return (root, query, cb) -> {
            if (min == null && max == null) return null;
            if (min == null) return cb.le(root.get("amount"), max);
            if (max == null) return cb.ge(root.get("amount"), min);
            return cb.between(root.get("amount"), min, max);
        };
    }

    public static Specification<Expense> dateBetween(
            LocalDate start, LocalDate end) {

        return (root, query, cb) -> {
            if (start == null && end == null) return null;
            if (start == null) return cb.lessThanOrEqualTo(root.get("date"), end);
            if (end == null) return cb.greaterThanOrEqualTo(root.get("date"), start);
            return cb.between(root.get("date"), start, end);
        };
    }
}
