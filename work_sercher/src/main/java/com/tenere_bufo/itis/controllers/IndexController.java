package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class IndexController {

    private final CompanyService companyService;

    @Autowired
    public IndexController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/index")
    public String getIndex(Map<String, Object> model){
        List<Company> companiesAll = companyService.findAll();
        List<Company> companies = IntStream.range(0, 5).mapToObj(companiesAll::get).collect(Collectors.toList());
        model.put("companies", companies);
        return "index";
    }

    @PostMapping("/index")
    public String findJob(){
        return "redirect:/jobs";
    }

}
