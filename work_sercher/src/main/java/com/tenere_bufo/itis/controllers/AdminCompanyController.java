package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
        try {
            Long id = Long.parseLong(keyword);
            Optional<Company> company = companyService.findById(id);
            company.ifPresent(res::add);
        } catch (NumberFormatException e) {
            log.info("keyword is not number");
        }
        if (keyword.equals("all")) {
            res.addAll(companyService.findAll());
        }
        model.addAttribute("companies", res);
        return "admin_company";
    }

   /* @PostMapping("/comp/add")
    public ResponseEntity<Company> addCompany(@RequestBody @Valid Company company, HttpServletRequest request) {
        if (checkOnRoleAdmin(request)) {
            companyService.save(company);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }*/

    @PostMapping("/comp/delete")
    public String deleteCompany(@RequestParam(value = "keyword") Long id) {
        log.info("request param is "+ id);
        /*if (checkOnRoleAdmin(request)) {
            companyService.delete(company);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }*/
        if(id!=null){
        Optional<Company> company = companyService.findById(id);
        company.ifPresent(companyService::delete);
        log.info("та простит меня господь, но мне лень сейчас писать апдейт");
        }
        return "redirect:/comp";
    }
}
