package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("User with email already exists");
        } else {
            user.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears());
            return userRepository.save(user);
        }
    }
}
