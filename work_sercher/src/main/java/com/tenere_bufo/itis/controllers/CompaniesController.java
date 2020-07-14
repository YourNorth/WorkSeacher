package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class CompaniesController {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompaniesController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/company/{name}")
    public String getCompany(@PathVariable("name") String name, Map<String, Object> model){
        Optional<Company> companies = companyRepository.findByName(name);
        if (companies.isPresent()){
            model.put("companies", Collections.singletonList(companies.get()));
            return "job_details";
        }
        return "jobs";
    }
}
