package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain(){
        return "redirect:/signIn";
    }

    @GetMapping("/elements")
    public String getElements(){
        return "elements";
    }

    @GetMapping("/blog")
    public String getBlog(){
        return "blog";
    }

    @GetMapping("/candidate")
    public String getCandidate(){
        return "candidate";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/job_details")
    public String getJobDetails(){
        return "job_details";
    }

    @GetMapping("/jobs")
    public String getJobs(){
        return "jobs";
    }

    @PostMapping("/jobs")
    public String findJobsForStudents(Company company){
        System.out.println(company);
        return "jobs";
    }

    @GetMapping("/single_blog")
    public String getSingleBlog(){
        return "single-blog";
    }
}
