
package com.examportal.service;



import com.examportal.model.Exam;

import com.examportal.repository.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service

public class ExamService {

  @Autowired

  private ExamRepository examRepository;

  public Exam createExam(Exam exam) {

    return examRepository.save(exam);

  }

  public Optional<Exam> getExamById(Long id) {

    return examRepository.findById(id);

  }

  public List<Exam> getAllExams() {

    return examRepository.findAll();

  }

}



