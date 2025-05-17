package com.example.demo.service;

import com.example.demo.repository.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    public List<User> helloWorld() {
        return List.of(
                new User(1L, "Sergey", 20, LocalDate.of(1996, 6, 1), "personal.email@mail.ru"),
                new User(2L, "Ivan", 21, LocalDate.of(1997, 6, 1), "personal.email@mail.ru"),
                new User(3L, "Sasha", 22, LocalDate.of(1998, 6, 1), "personal.email@mail.ru")
        );
    }
}
