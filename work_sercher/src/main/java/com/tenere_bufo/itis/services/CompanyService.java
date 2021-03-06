package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    Optional<Company> findByName(String name);
    Optional<Company> findByEmail(String email);
    Optional<Company> findById(Long id);
    List<Company> findByLocation(String location);
    List<Company> findByCategory(String category);
    List<Company> findByExperience(String experience);
    List<Company> findByJobType(String job_type);
    List<Company> findByQualification(String qualification);
    List<Company> findByGender(String gender);
    List<Company> findAll();
    Company save(Company company);
    void delete(Company company);
    void registerByAdmin(Company company);
}
