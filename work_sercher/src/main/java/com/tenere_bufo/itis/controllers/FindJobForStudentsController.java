package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FindJobForStudentsController {

    @GetMapping("/jobs")
    public String getJobs(){
        return "jobs";
    }

    @PostMapping("/jobs")
    public String findJobsForStudents(Company company){
        System.out.println(company);
        return "jobs";
    }
}
