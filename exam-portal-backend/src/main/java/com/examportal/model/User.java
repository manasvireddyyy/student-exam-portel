package com.examportal.model;



import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;



@Entity

@Data

@NoArgsConstructor

@AllArgsConstructor

public class User {



  public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



@Id

  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;



  private String name;

  private String email;

  private String password;



  @Enumerated(EnumType.STRING)

  private Role role;

}