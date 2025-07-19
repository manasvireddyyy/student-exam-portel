package com.examportal.controller;



import com.examportal.model.Submission;

import com.examportal.repository.SubmissionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/submissions")

@CrossOrigin(origins = "*")

public class SubmissionController {

  @Autowired

  private SubmissionRepository submissionRepository;

  // ✅ Submit an exam

  @PostMapping("/submit")

  public ResponseEntity<?> submitExam(@RequestBody Submission submission) {

    Submission saved = submissionRepository.save(submission);

    return ResponseEntity.ok(saved);

  }

  // ✅ Get submissions by user email

  @GetMapping("/by-user/{email}")

  public ResponseEntity<?> getSubmissionsByUser(@PathVariable String email) {

    List<Submission> list = submissionRepository.findByUserEmail(email);

    return ResponseEntity.ok(list);

  }

  // ✅ Get submissions by exam

  @GetMapping("/by-exam/{examId}")

  public ResponseEntity<?> getSubmissionsByExam(@PathVariable Long examId) {

    List<Submission> list = submissionRepository.findByExamId(examId);

    return ResponseEntity.ok(list);

  }

  // ✅ Get all submissions

  @GetMapping("/all")

  public List<Submission> getAll() {

    return submissionRepository.findAll();

  }

}















