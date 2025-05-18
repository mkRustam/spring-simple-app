package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Сущность, Тип_идентификатора>
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "select * from users where email = :email", nativeQuery = true) // Native SQL
//    User findByEmail(String email);

//    @Query(value = "select u from User u where u.email = :email") // JPQL
//    User findByEmail(String email);

//    User findByEmail(String email); // JPA Query Methods

   Boolean existsByEmail(String email);
}
