package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Сущность, Тип_идентификатора>
public interface UserRepository extends JpaRepository<User, Long> {
}
