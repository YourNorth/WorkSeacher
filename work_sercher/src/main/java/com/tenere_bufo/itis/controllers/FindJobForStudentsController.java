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
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
public class FindJobForStudentsController {
    private final String DEFAULT_VALUE_FOR_NAME = "";
    private final String DEFAULT_VALUE_FOR_LOCATION = "Location";
    private final String DEFAULT_VALUE_FOR_CATEGORY = "Category";
    private final String DEFAULT_VALUE_FOR_EXPERIENCE = "Experience";
    private final String DEFAULT_VALUE_FOR_JOBTYPE = "Job type";
    private final String DEFAULT_VALUE_FOR_QUALIFICATION = "Qualification";
    private final String DEFAULT_VALUE_FOR_GENDER = "Gender";
    private final String DEFAULT_VALUE_FOR_AMOUNT = "$750 - $24600/ Year";

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
        model.put("companies", sortByParameters(company));
        return "jobs";
    }

    private List<Company> sortByParameters(Company company) {
        List<Company> companies = companyRepository.findAll();
        companies = sortByName(company, companies);
        companies = sortByLocation(company, companies);
        companies = sortByCategory(company, companies);
        companies = sortByExperience(company, companies);
        companies = sortByJobType(company, companies);
        companies = sortByQualification(company, companies);
        companies = sortByGender(company, companies);
        companies = sortByAmount(company, companies);
        return companies;
    }

    private List<Company> sortByName(Company company, List<Company> companies) {
        if (!company.getName().equals(DEFAULT_VALUE_FOR_NAME)) {
            companies = companies.stream().filter(s -> s.getName()
                    .equalsIgnoreCase(company.getName()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByLocation(Company company, List<Company> companies) {
        if (!company.getLocation().equals(DEFAULT_VALUE_FOR_LOCATION)) {
            companies = companies.stream().filter(s -> s.getLocation().equalsIgnoreCase(company.getLocation()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByCategory(Company company, List<Company> companies) {
        if (!company.getCategory().equals(DEFAULT_VALUE_FOR_CATEGORY)) {
            companies = companies.stream().filter(s -> s.getCategory()
                    .equalsIgnoreCase(company.getCategory()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByExperience(Company company, List<Company> companies) {
        if (!company.getExperience().equals(DEFAULT_VALUE_FOR_EXPERIENCE)) {
            companies = companies.stream().filter(s -> s.getExperience()
                    .equalsIgnoreCase(company.getExperience()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByJobType(Company company, List<Company> companies) {
        if (!company.getJobType().equals(DEFAULT_VALUE_FOR_JOBTYPE)) {
            companies = companies.stream().filter(s -> s.getJobType()
                    .equalsIgnoreCase(company.getJobType()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByQualification(Company company, List<Company> companies) {
        if (!company.getQualification().equals(DEFAULT_VALUE_FOR_QUALIFICATION)) {
            companies = companies.stream().filter(s -> s.getQualification()
                    .equalsIgnoreCase(company.getQualification()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByGender(Company company, List<Company> companies) {
        if (!company.getGender().equals(DEFAULT_VALUE_FOR_GENDER)) {
            companies = companies.stream().filter(s -> s.getGender()
                    .equalsIgnoreCase(company.getGender()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> sortByAmount(Company company, List<Company> companies) {
        if (!company.getAmount().equals(DEFAULT_VALUE_FOR_AMOUNT)) {
            String input = company.getAmount();
            Pattern pattern = Pattern.compile("[ $-/Year]");
            String[] words = pattern.split(input);
            int min = Integer.valueOf(words[1]);
            int max = Integer.valueOf(words[5]);
            companies = companies.stream().filter(s ->
                    Integer.valueOf(s.getAmount().substring(1)) > min)
                    .collect(Collectors.toList());
            companies = companies.stream().filter(s ->
                    Integer.valueOf(s.getAmount().substring(1)) < max)
                    .collect(Collectors.toList());
        }
        return companies;
    }
}
