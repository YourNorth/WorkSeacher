package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getSignUp(ModelMap map){
        Attributes.addSuccessAttributes(map,"You have successfully logged in!");
        return "signUp";
    }

    @PostMapping
    public String signUp(User user, HttpSession session){
        userService.register(user, session);
        return "redirect:/index";
    }
}
