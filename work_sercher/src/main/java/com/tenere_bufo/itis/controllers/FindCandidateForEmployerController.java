package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FindCandidateForEmployerController {

    private final UserRepository userRepository;

    @Autowired
    public FindCandidateForEmployerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/candidate")
    public String getCandidate(Map<String, Object> model){
        List<User> users = userRepository.findAll();
        model.put("users", users);
        return "candidate";
    }

    @PostMapping("/candidate")
    public String findCandidateForEmployer(User user, Map<String, Object> model){
        //User(age=null, firstName=null, lastName=null, email=null, password=null,
        // description=null, country=null, city=null, gender=null, token=null, general_skill=null,
        // education=null, native_language=null, link_img=null, roles=null, skills=null)
        model.put("users", sortByParameters(user));
        System.out.println(user);
        return "candidate";
    }

    private List<User> sortByParameters(User user) {
        List<User> companies = userRepository.findAll();
//        companies = sortByName(company, companies);
//        companies = sortByLocation(company, companies);
//        companies = sortByCategory(company, companies);
//        companies = sortByExperience(company, companies);
//        companies = sortByJobType(company, companies);
//        companies = sortByQualification(company, companies);
//        companies = sortByGender(company, companies);
//        companies = sortByAmount(company, companies);
        return companies;
    }
}
