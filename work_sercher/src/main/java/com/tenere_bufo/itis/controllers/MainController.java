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

    @GetMapping("/single_blog")
    public String getSingleBlog(){
        return "single-blog";
    }
}
