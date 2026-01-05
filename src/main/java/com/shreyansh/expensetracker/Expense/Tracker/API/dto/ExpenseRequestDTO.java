package com.shreyansh.expensetracker.Expense.Tracker.API.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseRequestDTO {

    private String title;
    private double amount;
    private LocalDate date;
    private String description;
}
