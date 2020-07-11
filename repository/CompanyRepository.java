package ru.springsecurity.jwtappdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springsecurity.jwtappdemo.model.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);
}
