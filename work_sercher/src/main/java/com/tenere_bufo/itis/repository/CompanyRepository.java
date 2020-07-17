package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);
    Optional<Company> findByEmail(String email);
    List<Company> findByLocation(String location);
    List<Company> findByCategory(String category);
    List<Company> findByExperience(String experience);
    List<Company> findByJobType(String job_type);
    List<Company> findByQualification(String qualification);
    List<Company> findByGender(String gender);
}
