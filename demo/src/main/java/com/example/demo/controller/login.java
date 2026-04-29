package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.loginservice;
import com.example.demo.entity.loginentity;

@RestController
@RequestMapping("/api/auth")
public class login {

    @Autowired
    private loginservice loginservice;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody loginentity user) {
        return loginservice.login(user.getEmail(), user.getPassword());
    }
    
    @Autowired 
    private signupservice signupservice;
    
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody signupentity user){
    	return signupservice.signup(user.postEmail(), user.postPassword());
    }
    
    
}

