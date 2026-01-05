package com.shreyansh.expensetracker.Expense.Tracker.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shreyansh.expensetracker.Expense.Tracker.API.dto.LoginRequestDTO;
import com.shreyansh.expensetracker.Expense.Tracker.API.dto.LoginResponseDTO;
import com.shreyansh.expensetracker.Expense.Tracker.API.model.User;
import com.shreyansh.expensetracker.Expense.Tracker.API.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request) {

        LoginResponseDTO response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
