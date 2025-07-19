package com.examportal.dto;



import lombok.AllArgsConstructor;

import lombok.Data;

@Data

@AllArgsConstructor

public class AuthResponse {

  public AuthResponse(String token2) {
		// TODO Auto-generated constructor stub
	}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

private String token;

}



