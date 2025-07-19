
package com.examportal.controller;



import com.examportal.model.Exam;

import com.examportal.model.Question;

import com.examportal.repository.ExamRepository;

import com.examportal.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController

@RequestMapping("/api/questions")

@CrossOrigin(origins = "*")

public class QuestionController {

  @Autowired

  private ExamRepository examRepository;

  @Autowired

  private QuestionRepository questionRepository;

  // ✅ Add a question to an exam using if-else

  @PostMapping("/add")

  public ResponseEntity<?> addQuestion(@RequestParam Long examId, @RequestBody Question question) {

    Optional<Exam> optionalExam = examRepository.findById(examId);

    if (optionalExam.isPresent()) {

      Exam exam = optionalExam.get();

      question.setExam(exam);

      Question savedQuestion = questionRepository.save(question);

      return ResponseEntity.ok(savedQuestion);

    } else {

      return ResponseEntity.badRequest().body("Exam with ID " + examId + " not found");

    }

  }

  // ✅ Get questions by exam ID using if-else

  @GetMapping("/by-exam/{examId}")

  public ResponseEntity<?> getQuestions(@PathVariable Long examId) {

    Optional<Exam> optionalExam = examRepository.findById(examId);

    if (optionalExam.isPresent()) {

      Exam exam = optionalExam.get();

      List<Question> questions = questionRepository.findByExam(exam);

      return ResponseEntity.ok(questions);

    } else {

      return ResponseEntity.status(404).body("Exam with ID " + examId + " not found");

    }

  }

}















