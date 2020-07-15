package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.FeedbackForCandidate;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.CompanyService;
import com.tenere_bufo.itis.services.FeedbackForCandidateService;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
            model.put("companies", Collections.singletonList(companies.get()));
            return "job_details";
        }
        return "jobs";
    }

    @PostMapping("/company/{name}")
    public String toSendLetter(@PathVariable("name") String name, FeedbackForCandidate feedback, ServletRequest servletRequest){
        feedback.setCreated(new Date());
        feedback.setUpdated(new Date());
        feedback.setStatus(State.ACTIVE);
        Company company = companyService.findByName(name).get();
        feedback.setCompany_id(company.getId());
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if (session.getAttribute("email") != null){
            User user = userService.find((String) session.getAttribute("email")).get();
            feedback.setUser_id(user.getId());
            feedbackForCandidateService.save(feedback);
        }
        return "redirect:/company/{name}";
    }
}
