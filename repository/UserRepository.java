package ru.springsecurity.jwtappdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springsecurity.jwtappdemo.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
