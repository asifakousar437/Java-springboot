package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.loginentity;

public interface loginrepo extends JpaRepository<loginentity, Long> {

    loginentity findByEmail(String email);
}