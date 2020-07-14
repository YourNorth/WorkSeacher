package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Company;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class FindCandidateForEmployerController {

    private final UserRepository userRepository;

    @Autowired
    public FindCandidateForEmployerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/candidate")
    public String getCandidate(Map<String, Object> model){
        List<User> users = userRepository.findAll();
        model.put("users", users);
        return "candidate";
    }

    @PostMapping("/candidate")
    public String findCandidateForEmployer(User user, Map<String, Object> model){
        //User(age=null, firstName=, lastName=, email=null, password=null, description=null, country=, city=, gender=Gender,
        // token=null, general_skill=, education=null, native_language=, link_img=null, roles=null, skills=null)
        model.put("users", sortByParameters(user));
        System.out.println(user);
        return "candidate";
    }

    private List<User> sortByParameters(User user) {
        List<User> users = userRepository.findAll();
        users = sortByFirstName(user, users);
        users = sortByLastName(user, users);
        users = sortByCountry(user, users);
        users = sortByCity(user, users);
        users = sortByGeneralSkill(user, users);
        users = sortByNativeLanguage(user, users);
        users = sortByNativeLanguage(user, users);
        users = sortByGender(user, users);
        return users;
    }

    private List<User> sortByFirstName(User user, List<User> users) {
        if (!user.getFirstName().equals("")){
            users = users.stream().filter(s -> s.getFirstName()
                    .equalsIgnoreCase(user.getFirstName()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    private List<User> sortByLastName(User user, List<User> users) {
        if (!user.getLastName().equals("")){
            users = users.stream().filter(s -> s.getLastName()
                    .equalsIgnoreCase(user.getLastName()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    private List<User> sortByCountry(User user, List<User> users) {
        return users;
    }

    private List<User> sortByCity(User user, List<User> users) {
        return users;
    }

    private List<User> sortByGeneralSkill(User user, List<User> users) {
        return users;
    }

    private List<User> sortByNativeLanguage(User user, List<User> users) {
        return users;
    }

    private List<User> sortByGender(User user, List<User> users) {
        return users;
    }
}
