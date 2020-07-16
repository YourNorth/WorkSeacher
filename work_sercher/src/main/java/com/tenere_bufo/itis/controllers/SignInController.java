package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    public String getSignIn(HttpServletRequest request, ModelMap modelMap, @RequestParam(value = "error", required = false) String error){
        LogManager.getLogManager().reset();
        HttpSession session = request.getSession(false);
        if (session != null){
            AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                Attributes.addErrorAttributes(modelMap, ex.getMessage());
            }
        }

        return "signIn";
    }

}
