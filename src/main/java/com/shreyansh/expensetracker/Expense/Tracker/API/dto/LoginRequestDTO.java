package com.shreyansh.expensetracker.Expense.Tracker.API.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
