package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.dto.AuthenticationRequestDto;
import com.tenere_bufo.itis.model.User;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(User user, HttpSession session);

    boolean signIn(AuthenticationRequestDto userForm, ModelMap modelMap, HttpSession session);

    List<User> findAll();

    Optional<User> find(String email);

    void add(User user);
}
