package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.CompanyRepository;
import com.tenere_bufo.itis.repository.UserRepository2;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

@Controller
public class CreateProfileController {

    private final CompanyRepository companyRepository;
    private final UserRepository2 userRepository2;

    @Autowired
    public CreateProfileController(CompanyRepository companyRepository, UserRepository2 userRepository2) {
        this.companyRepository = companyRepository;
        this.userRepository2 = userRepository2;
    }

    @GetMapping("/create_profile")
    public String getCreateProfile(HttpServletRequest request){
        if (request.isUserInRole("ROLE_USER"))                          //if(role = user) -> return "profile_candidate"
            return "profile_candidate";
        if (request.isUserInRole("ROLE_EMPLOYER"))                      //if(role = employer) -> return "profile_work"
            return "profile_work";
        return "profile_candidate";
    }

    @PostMapping("/create_profile_candidate")
    public String createProfileForCandidate(User user, Authentication authentication){
        System.out.println(user);
        if (authentication != null) {
            User u = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
            userRepository2.updateByEmail(user, u.getEmail());
        }
        return "profile_candidate";
    }

    @PostMapping("/create_profile_employer")
    public String createProfileForEmployer(Company company, Authentication authentication){
        List<String> images = Arrays.asList("/img/svg_icon/1.svg", "/img/svg_icon/2.svg", "/img/svg_icon/3.svg",
                "/img/svg_icon/4.svg", "/img/svg_icon/5.svg");
        company.setLink_img(images.get((int) (Math.random() * 5)));
        company.setAmount("$" + company.getAmount());
        company.setStatus(State.ACTIVE);
        company.setCreated(new Date());
        company.setUpdated(new Date());
        if (authentication != null) {
            User u = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
            company.setEmail(u.getEmail());
        }
        companyRepository.save(company);
        return "profile_candidate";
    }
}
