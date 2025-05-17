package com.example.demo.repository;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Обозначение что генерацией Id будет заниматься БД
    private Long id;
    // @Column(name = "name") // Для случаев когда название переменной отличается от названия поля в БД
    private String name;
    private Integer age;
    private LocalDate birth;
    private String email;

    public User() {
    }

    public User(Long id, String name, Integer age, LocalDate birth, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
