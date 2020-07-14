package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MainController {

    @PreAuthorize("permitAll()")
    @GetMapping("/")
    public String getMain(Authentication authentication) {
        log.info("getMain() returns " + authentication);
        if(authentication!=null&&authentication.isAuthenticated()){
            return "index";
        }
        return "redirect:signIn";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/elements")
    public String getElements() {
        return "elements";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/blog")
    public String getBlog() {
        return "blog";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/candidate")
    public String getCandidate() {
        return "candidate";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/job_details")
    public String getJobDetails() {
        return "job_details";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/single_blog")
    public String getSingleBlog() {
        return "single-blog";
    }
}
