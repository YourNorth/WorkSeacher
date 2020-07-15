package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/index")
    public String findJob(Company company){
        return "redirect:/jobs";
    }

}
