package com.tenere_bufo.itis.services;


import com.tenere_bufo.itis.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(User user, String captchaResponse);

    boolean signIn(User user, ModelMap modelMap, HttpSession session, String captchaResponse);

    boolean confirm(String token, ModelMap model, HttpSession session);

    List<User> findAll();

    Optional<User> find(String email);

    void delete(User user);

    void add(User user);

    void updateStatus(User user);

    Optional<User> findByToken(String token);
}
