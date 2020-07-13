package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FindJobForStudentsController {

    private final CompanyRepository companyRepository;

    @Autowired
    public FindJobForStudentsController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/jobs")
    public String getJobs(Map<String, Object> model){
        List<Company> companies = companyRepository.findAll();
        model.put("companies", companies);
        return "jobs";
    }

    @PostMapping("/jobs")
    public String findJobsForStudents(Company company){
        System.out.println(company);
        return "jobs";
    }
}
