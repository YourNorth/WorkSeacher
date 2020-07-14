package com.tenere_bufo.itis.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PreAuthorize("permitAll()")
    @GetMapping("/logout")
    String getLogout(Model model, Authentication authentication) {
        return "redirect:signIn";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/logout")
    String postLogout(Model model) {
        return "logout";
    }
}

