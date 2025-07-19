package com.examportal.model;



import jakarta.persistence.*;

import lombok.*;

@Entity

@Data

@NoArgsConstructor

@AllArgsConstructor

public class Submission {

  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAnswersJson() {
		return answersJson;
	}

	public void setAnswersJson(String answersJson) {
		this.answersJson = answersJson;
	}

@Id

  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  private String userEmail;

  private Long examId;

  private int score;

  @Lob

  private String answersJson; // Store answers as JSON string (optional)

}