package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminCompanyController {

    private final CompanyService companyService;

    public AdminCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/comp/{id}")
    public Company getCompany(@PathVariable("id") Long id, HttpServletRequest request){
        return checkOnRoleAdmin(request) ? companyService.findById(id).orElse(new Company()) : new Company();
    }

    @GetMapping("/comp/all")
    public List<Company> getCompanies(HttpServletRequest request){
        return checkOnRoleAdmin(request) ? companyService.findAll() : new ArrayList<>();
    }

    @PostMapping("/comp/add")
    public ResponseEntity<Company> addCompany(@RequestBody @Valid Company company, HttpServletRequest request) {
        if (checkOnRoleAdmin(request)){
            companyService.save(company);
            return ResponseEntity.status(200).build();
        }else{
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/comp/delete")
    public ResponseEntity<Company> deleteCompany(@RequestBody Company company, HttpServletRequest request){
        if (checkOnRoleAdmin(request)){
            companyService.delete(company);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(403).build();
        }
    }

    private boolean checkOnRoleAdmin(HttpServletRequest request){
        return request.isUserInRole("ROLE_ADMIN");
    }
}
