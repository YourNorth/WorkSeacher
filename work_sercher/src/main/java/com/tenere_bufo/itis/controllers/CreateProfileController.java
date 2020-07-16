package com.tenere_bufo.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateProfileController {

    @GetMapping("/create_profile")
    public String getCreateProfile(){
        //if(role = user) -> return "profile_candidate"
        //if(role = employer) -> return "profile_work"
        return "profile_candidate";
    }
}
