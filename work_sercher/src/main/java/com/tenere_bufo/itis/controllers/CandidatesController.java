package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.FeedbackForEmployer;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class CandidatesController {

    private final UserService userService;

    @Autowired
    public CandidatesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/candidate/{id}")
    public String getUser(@PathVariable("id") Long id, Map<String, Object> model){
        Optional<User> users = userService.findById(id);
        if (users.isPresent()){
            model.put("users", Collections.singletonList(users.get()));
            return "candidate_details";
        }
        return "candidate";
    }

    @PostMapping("/candidate/{id}")
    public String toSendLetter(@PathVariable("id") Long id, FeedbackForEmployer feedback){
        System.out.println(feedback);
        return "redirect:/candidate/{id}";
    }
}
