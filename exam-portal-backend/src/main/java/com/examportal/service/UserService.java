package com.examportal.service;



import com.examportal.model.User;

import com.examportal.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;



@Service

public class UserService {



  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;



  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

    this.userRepository = userRepository;

    this.passwordEncoder = passwordEncoder;

  }



  public User registerUser(User user) {

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);

  }

}

