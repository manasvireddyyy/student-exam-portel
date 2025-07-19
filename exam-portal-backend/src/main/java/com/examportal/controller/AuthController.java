package com.examportal.controller;



import com.examportal.dto.LoginRequest;

import com.examportal.dto.LoginResponse;

import com.examportal.model.User;

import com.examportal.repository.UserRepository;

import com.examportal.service.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/api/auth")

@CrossOrigin(origins = "*")

public class AuthController {

  @Autowired

  private UserRepository userRepository;

  @Autowired

  private PasswordEncoder passwordEncoder;

  @Autowired

  private JwtUtil jwtUtil;

  // ✅ REGISTER

  @PostMapping("/register")

  public User register(@RequestBody User user) {

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);

  }

  // ✅ LOGIN

  @PostMapping("/login")

  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

    Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());

    if (optionalUser.isPresent()) {

      User user = optionalUser.get();

      if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(new LoginResponse(token));

      } else {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

      }

    } else {

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

    }

  }

  @GetMapping("/user/{email}")

  public ResponseEntity<?> getUserByEmail(@PathVariable String email) {

    Optional<User> optionalUser = userRepository.findByEmail(email);

    if (optionalUser.isPresent()) {

      return ResponseEntity.ok(optionalUser.get());

    } else {

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

    }

  
  }

}























