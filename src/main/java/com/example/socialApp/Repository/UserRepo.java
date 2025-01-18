package com.example.socialApp.Repository;

import com.example.socialApp.model.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email); // Find user by email
}
