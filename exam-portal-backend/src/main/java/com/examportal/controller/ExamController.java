
package com.examportal.controller;



import com.examportal.model.Exam;

import com.examportal.repository.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/exams")

@CrossOrigin(origins = "*")

public class ExamController {

  @Autowired

  private ExamRepository examRepository;

  // Create new exam

  @PostMapping("/add")

  public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {

    Exam saved = examRepository.save(exam);

    return ResponseEntity.ok(saved);

  }

  // Get all exams

  @GetMapping

  public ResponseEntity<List<Exam>> getAllExams() {

    return ResponseEntity.ok(examRepository.findAll());

  }

  // Get exam by ID

  @GetMapping("/{id}")

  public ResponseEntity<?> getExam(@PathVariable Long id) {

    return examRepository.findById(id)

      .map(ResponseEntity::ok)

      .orElseGet(() -> ResponseEntity.notFound().build());

  }

}

