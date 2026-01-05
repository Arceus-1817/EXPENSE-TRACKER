package com.shreyansh.expensetracker.Expense.Tracker.API.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shreyansh.expensetracker.Expense.Tracker.API.dto.LoginRequestDTO;
import com.shreyansh.expensetracker.Expense.Tracker.API.dto.LoginResponseDTO;
import com.shreyansh.expensetracker.Expense.Tracker.API.model.User;
import com.shreyansh.expensetracker.Expense.Tracker.API.repo.UserRepo;
import com.shreyansh.expensetracker.Expense.Tracker.API.security.JwtUtil;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil =jwtUtil;
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);
    }

    public User getUserById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

   public LoginResponseDTO login(LoginRequestDTO request) {

    User user = userRepo.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Invalid email or password"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid email or password");
    }

    String token = jwtUtil.generateToken(user.getEmail(), user.getId());

    return new LoginResponseDTO(
            user.getId(),
            token
    );
}


    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);
    }
}
