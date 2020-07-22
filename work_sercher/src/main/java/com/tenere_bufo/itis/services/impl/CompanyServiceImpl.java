package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.Role;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.CompanyRepository;
import com.tenere_bufo.itis.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
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
    public Optional<Company> findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }


    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
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

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

    @Override
    public void registerByAdmin(Company company) {
        //name,amount,category,experience, gender,job_type,link_img,location,qualification
        company.setStatus(State.ACTIVE);
        company.setCreated(new Date());
        company.setUpdated(new Date());
        Company registeredCompany = companyRepository.save(company);
        log.info("IN register - company: {} successfully registered by admin", registeredCompany);
    }
}
