package com.examportal.config;











import com.examportal.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;

import org.springframework.security.authentication.*;

import org.springframework.security.config.annotation.authentication.configuration.*;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

@EnableWebSecurity

public class SecurityConfig {

 @Autowired private JwtFilter jwtFilter;

 @Autowired private CustomUserDetailsService userDetailsService;

 @Bean

 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

 return config.getAuthenticationManager();

 }

 @Bean

 public PasswordEncoder passwordEncoder() {

 return new BCryptPasswordEncoder();

 }

 @Bean

 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

   http.csrf(csrf -> csrf.disable())

     .authorizeHttpRequests(auth -> auth

       .requestMatchers("/api/auth/**").permitAll() // login/register

       .requestMatchers("/api/exams/**").authenticated() // protected

       .requestMatchers("/api/questions/**").authenticated()

       .anyRequest().authenticated()

     )

     .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

   http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

   return http.build();

 }



public CustomUserDetailsService getUserDetailsService() {

 return userDetailsService;

}

public void setUserDetailsService(CustomUserDetailsService userDetailsService) {

 this.userDetailsService = userDetailsService;

}

}



































































































































































































































































































