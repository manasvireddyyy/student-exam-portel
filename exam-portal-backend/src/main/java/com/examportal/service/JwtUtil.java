package com.examportal.service;



import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;

import java.util.Date;

@Component

public class JwtUtil {

  private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  private final long expirationMs = 1000 * 60 * 60 * 10; // 10 hours

  // Generate token using email

  public String generateToken(String email) {

    return Jwts.builder()

        .setSubject(email)

        .setIssuedAt(new Date(System.currentTimeMillis()))

        .setExpiration(new Date(System.currentTimeMillis() + expirationMs))

        .signWith(key)

        .compact();

  }

  // Extract email (username) from token

  public String extractUsername(String token) {

    return Jwts.parserBuilder()

        .setSigningKey(key)

        .build()

        .parseClaimsJws(token)

        .getBody()

        .getSubject();

  }

  // Validate token

  public boolean validateToken(String token) {

    try {

      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

      return true;

    } catch (JwtException | IllegalArgumentException e) {

      return false;

    }

  }

}













