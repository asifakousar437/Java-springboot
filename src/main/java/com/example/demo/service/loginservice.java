package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.loginentity;
import com.example.demo.repository.loginrepo;

@Service
public class loginservice {

    @Autowired
    private loginrepo loginrepo;

    public ResponseEntity<String> login(String email, String password) {

        loginentity user = loginrepo.findByEmail(email);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (!user.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        return ResponseEntity.ok("Login successful");
    }
}