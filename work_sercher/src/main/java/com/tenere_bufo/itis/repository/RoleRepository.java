package ru.springsecurity.jwtappdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springsecurity.jwtappdemo.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
