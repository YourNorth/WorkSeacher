package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.FeedbackForCandidate;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.CompanyService;
import com.tenere_bufo.itis.services.FeedbackForCandidateService;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
public class CompaniesController {

    private final CompanyService companyService;
    private final UserService userService;
    private final FeedbackForCandidateService feedbackForCandidateService;

    @Autowired
    public CompaniesController(CompanyService companyService, UserService userService, FeedbackForCandidateService feedbackForCandidateService) {
        this.companyService = companyService;
        this.userService = userService;
        this.feedbackForCandidateService = feedbackForCandidateService;
    }

    @GetMapping("/company/{name}")
    public String getCompany(@PathVariable("name") String name, Map<String, Object> model){
        Optional<Company> companies = companyService.findByName(name);
        if (companies.isPresent()){
            //если роль - employer, то return "job_details_less"
            //если роль - user, то return "job_details"
            model.put("companies", Collections.singletonList(companies.get()));
            return "job_details";
        }
        return "jobs";
    }

    @PostMapping("/company/{name}")
    public String toSendLetter(@PathVariable("name") String name, FeedbackForCandidate feedback, Authentication authentication){
        feedback.setCreated(new Date());
        feedback.setUpdated(new Date());
        feedback.setStatus(State.ACTIVE);
        Company company = companyService.findByName(name).get();
        feedback.setCompany_id(company.getId());
        if (authentication != null){
            User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
            feedback.setUser_id(user.getId());
            feedbackForCandidateService.save(feedback);
        }
        return "redirect:/company/{name}";
    }
}
