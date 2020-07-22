package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getCompany(@RequestParam(value = "keyword", defaultValue = "all") String keyword, Model model) {
        List<User> res = new LinkedList<>();
        if(idChecking(keyword)!=null){
            Optional<User> user = userService.findById(idChecking(keyword));
            user.ifPresent(res::add);
        }
        if (keyword.equals("all")) {
            res.addAll(userService.findAll());
        }
        model.addAttribute("users", res);
        return "admin_user";
    }

    @PostMapping("/user/delete")
    public String deleteCompany(@RequestParam(value = "keyword") String keyword) {
        if (idChecking(keyword) != null) {
            Optional<User> user = userService.findById(idChecking(keyword));
            user.ifPresent(userService::delete);//fixme update!
        }
        return "redirect:/user";
    }

    @GetMapping("/user/add")
    public String getAddUser() {
        return "admin_user_creating";
    }

    @PostMapping("/user/add")
    public String postAddUser(@ModelAttribute("userForm") User user) {
        userService.registerByAdmin(user);
        log.info(user.toString() + "is created");
        return "redirect:/user";
    }

    static Long idChecking(String keyword) {
        try {
            keyword = keyword.replaceAll("\\s","");
            Long id = Long.parseLong(keyword);
            return id;
        } catch (NumberFormatException e) {
            log.info("parameter is not number, numberFormatException message is: {}",e.getMessage());
        }
        return null;
    }
}
