package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.signupservice;
import com.example.demo.entity.loginentity;
@RestController
@RequestMapping("/api/auth")
public class signup {
    @Autowired
    private signupservice signupservice;
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody loginentity user) {
        return signupservice.signup(user.getEmail(), user.getPassword());
    }
}
