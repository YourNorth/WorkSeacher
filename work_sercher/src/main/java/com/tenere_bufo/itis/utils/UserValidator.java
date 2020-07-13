package com.tenere_bufo.itis.utils;

import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (userService.find(user.getEmail()).isPresent()) {
            errors.rejectValue(
                    "email", "This email is already in use", "This email is already in use"
            );
        }
    }
}

