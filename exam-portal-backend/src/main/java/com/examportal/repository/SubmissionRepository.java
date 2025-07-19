package com.examportal.repository;



import com.examportal.model.Submission;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

  List<Submission> findByUserEmail(String userEmail);

  List<Submission> findByExamId(Long examId);

}



