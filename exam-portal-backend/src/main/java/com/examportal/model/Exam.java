package com.examportal.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity

public class Exam {

  @Id

  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  private String title;

  private String description;

  @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)

  @JsonManagedReference

  private List<Question> questions;

  // Constructors

  public Exam() {}

  public Exam(String title, String description) {

    this.title = title;

    this.description = description;

  }

  // Getters and Setters

  public Long getId() {

    return id;

  }

  public void setId(Long id) {

    this.id = id;

  }

  public String getTitle() {

    return title;

  }

  public void setTitle(String title) {

    this.title = title;

  }

  public String getDescription() {

    return description;

  }

  public void setDescription(String description) {

    this.description = description;

  }

  public List<Question> getQuestions() {

    return questions;

  }

  public void setQuestions(List<Question> questions) {

    this.questions = questions;

  }

}































