package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.security.UserDetailsImpl;
import com.tenere_bufo.itis.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    String getProfile(Model model,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.info("user from @AuthenticationPrincipal: " + userDetails);
        model.addAttribute("user", userDetails.getUser());
        return "profile";
    }
}
