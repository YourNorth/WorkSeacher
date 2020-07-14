package com.tenere_bufo.itis.controllers;

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
    public String findCandidateForEmployer(){
        return "candidate";
    }
}
