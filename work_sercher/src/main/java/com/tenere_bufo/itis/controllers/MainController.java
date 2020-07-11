package com.tenere_bufo.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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

    @GetMapping("/single-blog")
    public String getSingleBlog(){
        return "single-blog";
    }
}
