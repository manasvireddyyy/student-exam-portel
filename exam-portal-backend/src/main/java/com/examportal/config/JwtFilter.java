package com.examportal.config;



import com.examportal.service.CustomUserDetailsService;

import com.examportal.service.JwtUtil;

import jakarta.servlet.*;

import jakarta.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.*;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component

public class JwtFilter extends OncePerRequestFilter {

  @Autowired private JwtUtil jwtUtil;

  @Autowired private CustomUserDetailsService userDetailsService;

  @Override

  protected void doFilterInternal(HttpServletRequest request,

                  HttpServletResponse response,

                  FilterChain filterChain) throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Bearer ")) {

      String token = authHeader.substring(7);

      String username = jwtUtil.extractUsername(token);

      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (jwtUtil.validateToken(token)) {

          UsernamePasswordAuthenticationToken authToken =

              new UsernamePasswordAuthenticationToken(

                  userDetails, null, userDetails.getAuthorities()

              );

          SecurityContextHolder.getContext().setAuthentication(authToken);

        }

      }

    }

    filterChain.doFilter(request, response);

  }

}

















