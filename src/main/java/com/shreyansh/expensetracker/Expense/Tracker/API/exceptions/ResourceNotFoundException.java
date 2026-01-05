package com.shreyansh.expensetracker.Expense.Tracker.API.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
