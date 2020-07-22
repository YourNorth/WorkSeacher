package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.tenere_bufo.itis.controllers.AdminUserController.idChecking;

@Slf4j
@Controller
public class AdminCompanyController {

    private final CompanyService companyService;

    public AdminCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/comp")
    public String getCompany(@RequestParam(value = "keyword", defaultValue = "all") String keyword, Model model) {
        List<Company> res = new LinkedList<>();
        if (idChecking(keyword) != null) {
            Optional<Company> company = companyService.findById(idChecking(keyword));
            company.ifPresent(res::add);
        }
        if (keyword.equals("all")) {
            res.addAll(companyService.findAll());
        }
        model.addAttribute("companies", res);
        return "admin_company";
    }

    @GetMapping("/comp/add")
    public String getAddComppany() {
        return "admin_company_creating";
    }

    @PostMapping("/comp/add")
    public String postAddCompany(@ModelAttribute("companyForm") Company company) {
        companyService.registerByAdmin(company);//fixme написать создание компании
        log.info(company.toString() + "is created");
        return "redirect:/comp";
    }

    @PostMapping("/comp/delete")
    public String deleteCompany(@RequestParam(value = "keyword") String keyword) {
        if (idChecking(keyword) != null) {
            Optional<Company> company = companyService.findById(idChecking(keyword));
            company.ifPresent(companyService::delete);//fixme update!
        }
        return "redirect:/comp";
    }


}
