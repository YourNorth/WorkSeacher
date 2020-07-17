package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminUserController {

    private final UserService userService;

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id, HttpServletRequest request){
        return checkOnRoleAdmin(request) ? userService.findById(id).orElse(new User()) : new User();
    }

    @GetMapping("/user/all")
    public List<User> getUsers(HttpServletRequest request){
        return checkOnRoleAdmin(request) ? userService.findAll() : new ArrayList<>();
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user, HttpServletRequest request) {
        if (checkOnRoleAdmin(request)){
            userService.register(user);
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/user/delete")
    public ResponseEntity<User> deleteUser(@RequestBody User user, HttpServletRequest request){
        if (checkOnRoleAdmin(request)){
            userService.delete(user);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(403).build();
        }
    }

    private boolean checkOnRoleAdmin(HttpServletRequest request){
        return request.isUserInRole("ROLE_ADMIN");
    }
}
