package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class FindCandidateForEmployerController {

    private final UserService userService;

    @Autowired
    public FindCandidateForEmployerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/candidate")
    public String getCandidate(Map<String, Object> model){
        List<User> users = userService.findAll()
                .stream().filter(s -> s.getDescription() != null)
                .collect(Collectors.toList());
        model.put("users", users);
        return "candidate";
    }

    @PostMapping("/candidate")
    public String findCandidateForEmployer(User user, Map<String, Object> model){
        model.put("users", sortByParameters(user));
        return "candidate";
    }

    private List<User> sortByParameters(User user) {
        List<User> users = userService.findAll();
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
        if (!user.getCountry().equals("")){
            users = users.stream().filter(s -> s.getCountry()
                    .equalsIgnoreCase(user.getCountry()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    private List<User> sortByCity(User user, List<User> users) {
        if (!user.getCity().equals("")){
            users = users.stream().filter(s -> s.getCity()
                    .equalsIgnoreCase(user.getCity()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    private List<User> sortByGeneralSkill(User user, List<User> users) {
        if (!user.getGeneral_skill().equals("")){
            users = users.stream().filter(s -> s.getGeneral_skill()
                    .equalsIgnoreCase(user.getGeneral_skill()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    private List<User> sortByNativeLanguage(User user, List<User> users) {
        if (!user.getNative_language().equals("")){
            users = users.stream().filter(s -> s.getNative_language()
                    .equalsIgnoreCase(user.getNative_language()))
                    .collect(Collectors.toList());
        }
        return users;
    }

    private List<User> sortByGender(User user, List<User> users) {
        if (!user.getGender().equals("Gender")){
            users = users.stream().filter(s -> s.getGender()
                    .equalsIgnoreCase(user.getGender()))
                    .collect(Collectors.toList());
        }
        return users;
    }
}
