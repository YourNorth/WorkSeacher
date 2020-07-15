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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.logging.LogManager;

@Controller
public class SignInController {

    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signIn")
    public String getSignIn(ModelMap modelMap, @RequestParam(value = "error", required = false) String error){
        LogManager.getLogManager().reset();
        if (error != null){
            Attributes.addErrorAttributes(modelMap,"Error, wrong login or password. Try again");
        }

        return "signIn";
    }

}
