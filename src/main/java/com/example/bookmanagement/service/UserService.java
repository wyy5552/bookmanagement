package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Member;
import com.example.bookmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Member findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Member save(Member member) {

        return userRepository.save(member);
    }
}
