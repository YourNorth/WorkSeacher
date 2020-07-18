package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import com.tenere_bufo.itis.repository.UserRepository2;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.CompanyService;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class CreateProfileController {

    private final CompanyService companyService;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public CreateProfileController(CompanyService companyService, UserRepository userRepository, UserService userService) {
        this.companyService = companyService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/create_profile")
    public String getCreateProfile(HttpServletRequest request, Authentication authentication) {
        User u = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        if (request.isUserInRole("ROLE_USER")) {
            Optional<User> user = userService.findByEmail(u.getEmail());
            if (user.isPresent()) {
                if (user.get().getDescription() != null) {
                    return "have_profile";
                } else {
                    return "profile_candidate";
                }
            }
        }
        if (request.isUserInRole("ROLE_EMPLOYER")) {
            Optional<Company> company = companyService.findByEmail(u.getEmail());
            if (company.isPresent()){
                return "have_profile";
            }else{
                return "profile_work";
            }
        }
        if(request.isUserInRole("ROLE_ADMIN")){
            return "have_profile";
        }
        return"profile_candidate";
    }


    @PostMapping("/create_profile_candidate")
    public String createProfileForCandidate(User user, Authentication authentication) {
        System.out.println(user);
        if (authentication != null) {
            User u = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
            u.setLink_img("/img/candiateds/" +(((int) ( Math.random() * 9)) + 1) + ".png");
            userRepository.updateByEmail(u.getEmail(),u.getAge(),u.getFirstName(),u.getLastName(),
                    u.getDescription(),u.getCountry(),u.getCity(),u.getGender(),u.getGeneral_skill(),
                    u.getEducation(),u.getNative_language(),u.getLink_img());
        }
        return "profile_candidate";
    }

    @PostMapping("/create_profile_employer")
    public String createProfileForEmployer(Company company, Authentication authentication) {
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
        companyService.save(company);
        return "profile_candidate";
    }
}
