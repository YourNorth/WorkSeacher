package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.CompanyService;
import com.tenere_bufo.itis.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getCompany(@RequestParam(value = "keyword", defaultValue = "all") String keyword, Model model) {
        List<User> res = new LinkedList<>();
        try {
            Long id = Long.parseLong(keyword);
            Optional<User> user = userService.findById(id);
            user.ifPresent(res::add);
        } catch (NumberFormatException e) {
            log.info("keyword is not number");
        }
        if (keyword.equals("all")) {
            res.addAll(userService.findAll());
        }
        model.addAttribute("users", res);
        return "admin_user";
    }

    @PostMapping("/user/delete")
    public String deleteCompany(@RequestParam(value = "keyword") Long id) {
        log.info("request param is "+ id);
        if(id!=null){
            Optional<User> company = userService.findById(id);
            company.ifPresent(userService::delete);
            log.info("та простит меня господь, но мне лень сейчас писать апдейт");
        }
        return "redirect:/user";
    }
}
