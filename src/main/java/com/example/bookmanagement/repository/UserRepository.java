package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
