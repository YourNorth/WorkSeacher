package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.logging.LogManager;

@Slf4j
@Controller
public class SignInController {

    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/signIn")
    public String getSignIn(ModelMap modelMap) {
        LogManager.getLogManager().reset();
        User user = new User();
        modelMap.addAttribute("user", user);
        Attributes.addSuccessAttributes(modelMap, "You have successfully logged in!");
        return "signIn";
    }

    /*@PreAuthorize("permitAll()")
    @PostMapping("/signIn")
    public String signIn(@ModelAttribute(value = "user") User user, ModelMap modelMap, HttpSession session,
                         @RequestParam("g-recaptcha-response") String captchaResponse) {
        System.out.println("sign in");
        if (userService.signIn(user, modelMap, session, captchaResponse)) {
            System.out.println("redirect to index from signIn");
            return "redirect:index";
        } else {
            return "signIn";
        }
    }*/
}
