package com.zenithdev.linkedin.hospitalManagement.repository;

import com.zenithdev.linkedin.hospitalManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}