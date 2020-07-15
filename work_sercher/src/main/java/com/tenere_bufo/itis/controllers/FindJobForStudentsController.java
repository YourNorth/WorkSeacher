package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
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

    private final CompanyService companyService;

    @Autowired
    public FindJobForStudentsController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/jobs")
    public String getJobs(Map<String, Object> model) {
        List<Company> companies = companyService.findAll();
        model.put("companies", companies);
        return "jobs";
    }

    @PostMapping("/jobs")
    public String findJobsForStudents(@RequestParam("sort") String sort, Company company, Map<String, Object> model) {
        model.put("companies", findByParameters(company, sort));
        return "jobs";
    }

    private List<Company> findByParameters(Company company, String sort) {
        List<Company> companies = companyService.findAll();
        companies = findByName(company, companies);
        companies = findByLocation(company, companies);
        companies = findByCategory(company, companies);
        companies = findByExperience(company, companies);
        companies = findByJobType(company, companies);
        companies = findByQualification(company, companies);
        companies = findByGender(company, companies);
        companies = findByAmount(company, companies);
        companies = sort(sort, companies);
        return companies;
    }

    private List<Company> findByName(Company company, List<Company> companies) {
        if (!company.getName().equals(DEFAULT_VALUE_FOR_NAME)) {
            companies = companies.stream().filter(s -> s.getName()
                    .equalsIgnoreCase(company.getName()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByLocation(Company company, List<Company> companies) {
        if (!company.getLocation().equals(DEFAULT_VALUE_FOR_LOCATION)) {
            companies = companies.stream().filter(s -> s.getLocation().equalsIgnoreCase(company.getLocation()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByCategory(Company company, List<Company> companies) {
        if (!company.getCategory().equals(DEFAULT_VALUE_FOR_CATEGORY)) {
            companies = companies.stream().filter(s -> s.getCategory()
                    .equalsIgnoreCase(company.getCategory()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByExperience(Company company, List<Company> companies) {
        if (!company.getExperience().equals(DEFAULT_VALUE_FOR_EXPERIENCE)) {
            companies = companies.stream().filter(s -> s.getExperience()
                    .equalsIgnoreCase(company.getExperience()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByJobType(Company company, List<Company> companies) {
        if (!company.getJobType().equals(DEFAULT_VALUE_FOR_JOBTYPE)) {
            companies = companies.stream().filter(s -> s.getJobType()
                    .equalsIgnoreCase(company.getJobType()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByQualification(Company company, List<Company> companies) {
        if (!company.getQualification().equals(DEFAULT_VALUE_FOR_QUALIFICATION)) {
            companies = companies.stream().filter(s -> s.getQualification()
                    .equalsIgnoreCase(company.getQualification()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByGender(Company company, List<Company> companies) {
        if (!company.getGender().equals(DEFAULT_VALUE_FOR_GENDER)) {
            companies = companies.stream().filter(s -> s.getGender()
                    .equalsIgnoreCase(company.getGender()))
                    .collect(Collectors.toList());
        }
        return companies;
    }

    private List<Company> findByAmount(Company company, List<Company> companies) {
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
    
    private List<Company> sort(String sort, List<Company> companies){
        if (!companies.isEmpty()){
            if (sort.equals("name")) companies.sort(Comparator.comparing(Company::getName));
            if (sort.equals("amount")) companies.sort(Comparator.comparing(Company::getAmount));
            if (sort.equals("location")) companies.sort(Comparator.comparing(Company::getLocation));
            if (sort.equals("jobType")) companies.sort(Comparator.comparing(Company::getJobType));
        }
        return companies;
    }
}
