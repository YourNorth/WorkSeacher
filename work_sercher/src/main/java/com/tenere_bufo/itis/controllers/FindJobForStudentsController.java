package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class FindJobForStudentsController {

    private final CompanyRepository companyRepository;

    @Autowired
    public FindJobForStudentsController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/jobs")
    public String getJobs(Map<String, Object> model) {
        List<Company> companies = companyRepository.findAll();
        model.put("companies", companies);
        return "jobs";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/jobs")
    public String findJobsForStudents(Company company, Map<String, Object> model) {
        model.put("companies", sortParameters(company));
        System.out.println(company);
        return "jobs";
    }

    private List<Company> sortParameters(Company company) {
        List<Company> companies = companyRepository.findAll();
        if (!company.getName().equals("")) {
            companies = companies.stream().filter(s -> s.getName()
                    .equalsIgnoreCase(company.getName()))
                    .collect(Collectors.toList());
        }
        if (!company.getLocation().equals("Location")) {
            companies = companies.stream().filter(s -> s.getLocation().equalsIgnoreCase(company.getLocation()))
                    .collect(Collectors.toList());
        }
        if (!company.getCategory().equals("Category")) {
            companies = companies.stream().filter(s -> s.getCategory()
                    .equalsIgnoreCase(company.getCategory()))
                    .collect(Collectors.toList());
        }
        if (!company.getExperience().equals("Experience")) {
            companies = companies.stream().filter(s -> s.getExperience()
                    .equalsIgnoreCase(company.getExperience()))
                    .collect(Collectors.toList());
        }
        if (!company.getJobType().equals("Job type")) {
            companies = companies.stream().filter(s -> s.getJobType()
                    .equalsIgnoreCase(company.getJobType()))
                    .collect(Collectors.toList());
        }
        if (!company.getQualification().equals("Qualification")) {
            companies = companies.stream().filter(s -> s.getQualification()
                    .equalsIgnoreCase(company.getQualification()))
                    .collect(Collectors.toList());
        }
        if (!company.getGender().equals("Gender")) {
            companies = companies.stream().filter(s -> s.getGender()
                    .equalsIgnoreCase(company.getGender()))
                    .collect(Collectors.toList());
        }
//        if (!company.getAmount().equals("$750 - $24600/ Year")){
//            String amount1 = company.getAmount().matches()
//            String amoount2 = company.getAmount().substring(8, )
//            companies = companies.stream().filter(s -> Integer.valueOf(s.getAmount().substring(1)) > )
//        }
        return companies;
    }
}
