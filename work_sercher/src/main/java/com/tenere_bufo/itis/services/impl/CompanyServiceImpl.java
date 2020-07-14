package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.repository.CompanyRepository;
import com.tenere_bufo.itis.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public List<Company> findByLocation(String location) {
        return companyRepository.findByLocation(location);
    }

    @Override
    public List<Company> findByCategory(String category) {
        return companyRepository.findByCategory(category);
    }

    @Override
    public List<Company> findByExperience(String experience) {
        return companyRepository.findByExperience(experience);
    }

    @Override
    public List<Company> findByJobType(String job_type) {
        return companyRepository.findByJobType(job_type);
    }

    @Override
    public List<Company> findByQualification(String qualification) {
        return companyRepository.findByQualification(qualification);
    }

    @Override
    public List<Company> findByGender(String gender) {
        return companyRepository.findByGender(gender);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
