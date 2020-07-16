package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateProfileController {

    @GetMapping("/create_profile")
    public String getCreateProfile(){
        //if(role = user) -> return "profile_candidate"
        //if(role = employer) -> return "profile_work"
        return "profile_candidate";
    }

    @PostMapping("/create_profile_candidate")
    public String createProfileForCandidate(User user){
        System.out.println(user);
        return "profile_candidate";
    }

    @PostMapping("/create_profile_employer")
    public String createProfileForEmployer(Company company){
        System.out.println(company);
        return "profile_candidate";
    }
}
