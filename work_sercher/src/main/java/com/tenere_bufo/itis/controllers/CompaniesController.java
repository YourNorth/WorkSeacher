package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.FeedbackForCandidate;
import com.tenere_bufo.itis.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class CompaniesController {

    private final CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company/{name}")
    public String getCompany(@PathVariable("name") String name, Map<String, Object> model){
        Optional<Company> companies = companyService.findByName(name);
        if (companies.isPresent()){
            model.put("companies", Collections.singletonList(companies.get()));
            return "job_details";
        }
        return "jobs";
    }

    @PostMapping("/company/{name}")
    public String toSendLetter(@PathVariable("name") String name, FeedbackForCandidate feedback){
        System.out.println(feedback);
        return "redirect:/company/{name}";
    }
}
