package com.shreyansh.expensetracker.Expense.Tracker.API.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpenseResponseDTO {
    private Long id;
    private String title;
    private double amount;
    private LocalDate date;
    private String description;
    private Long userId;
    private String categoryName;
}
