package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.CompanyService;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class MyProfileController {

    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public MyProfileController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping("/my_profile")
    public String myProfile(Authentication authentication, HttpServletRequest request, Map<String, Object> model){
        User u = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        if (request.isUserInRole("ROLE_USER")) {
            Optional<User> user = userService.findByEmail(u.getEmail());
            if (user.isPresent()) {
                if (user.get().getDescription() != null) {
                    model.put("users", Collections.singletonList(user.get()));
                    return "candidate_details_less";
                } else {
                    return "not_have_profile";
                }
            }
        }
        if (request.isUserInRole("ROLE_EMPLOYER")) {
            Optional<Company> company = companyService.findByEmail(u.getEmail());
            if (company.isPresent()){
                model.put("companies", Collections.singletonList(company.get()));
                return "job_details_less";
            }else{
                return "not_have_profile";
            }
        }
        if(request.isUserInRole("ROLE_ADMIN")){
            return "not_have_profile";
        }
        return"profile_candidate";
    }
}
