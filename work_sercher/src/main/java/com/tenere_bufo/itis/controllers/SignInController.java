package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.dto.AuthenticationRequestDto;
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
@RequestMapping("/signIn")
public class SignInController {

    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getSignIn(ModelMap modelMap){
        Attributes.addSuccessAttributes(modelMap,"You have successfully logged in!");
        return "signIn";
    }

    @PostMapping
    public String signIn(AuthenticationRequestDto authenticationRequestDto, ModelMap modelMap, HttpSession session) {
        if (userService.signIn(authenticationRequestDto, modelMap, session)) {
            return "redirect:/chat";
        }else{
            return "/signIn";
        }
    }
}
