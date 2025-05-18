package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

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
            throw new IllegalStateException("Пользователь с такой почтой уже существует");
        } else {
            user.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears());
            return userRepository.save(user);
        }
    }

    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Пользователь с таким id не сущесвует");
        }
    }

    @jakarta.transaction.Transactional
    public void update(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("Пользователя с таким id не существует");
        }

        User currentUser = optionalUser.get();
        if (user.getName() != null && !user.getName().isEmpty() && !user.getName().equals(currentUser.getName())) {
            currentUser.setName(user.getName());
        }
        if (user.getEmail() != null && !user.getEmail().isEmpty() && !user.getEmail().equals(currentUser.getEmail())) {
            if (userRepository.existsByEmail(user.getEmail())) {
                throw new IllegalStateException("Пользователь с такой почтой уже существует");
            } else {
                currentUser.setEmail(user.getEmail());
            }
        }
        if (user.getBirth() != null && !user.getBirth().isEqual(currentUser.getBirth())) {
            currentUser.setBirth(user.getBirth());
            currentUser.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears());
        }

        // >>> Почему нет вызова метода userRepository.save(currentUser) ?
        // Так как у метода стоит аннотация @Transactional, то обновление данных в бд
        // будет происходить через сеттеры сущности user, поэтому можно обойтись без
        // вызова userRepository.save(currentUser);
        // Если в методе update произойдет ошибка, то все изменения откатятся
    }
}
