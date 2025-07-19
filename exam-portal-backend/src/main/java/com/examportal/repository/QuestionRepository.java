package com.examportal.repository;



import com.examportal.model.Question;

import com.examportal.model.Exam;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

  List<Question> findByExam(Exam exam);

}