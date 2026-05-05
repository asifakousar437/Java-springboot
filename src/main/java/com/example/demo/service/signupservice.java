package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.loginentity;
import com.example.demo.repository.loginrepo;
@Service
public class signupservice {
    @Autowired
    private loginrepo loginrepo;

    public ResponseEntity<String> signup(String email, String password) {
        if (loginrepo.findByEmail(email) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        loginentity newUser = new loginentity();
        newUser.setEmail(email);
        newUser.setPassword(password);
        loginrepo.save(newUser);

        return ResponseEntity.ok("Signup successful");
    }
}
