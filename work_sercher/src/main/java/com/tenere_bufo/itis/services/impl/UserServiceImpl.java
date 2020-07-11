package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.dto.AuthenticationRequestDto;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user, HttpSession session) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        add(user);
        log.info("IN register - user: {} successfully registered: ", user);
        session.setAttribute("email", user.getEmail());
    }

    @Override
    public boolean signIn(AuthenticationRequestDto userForm, ModelMap model, HttpSession session) {
        User user = find(userForm.getEmail()).orElse(null);
        if (user == null || !passwordEncoder.matches(userForm.getPassword(), user.getPassword())) {
            Attributes.addErrorAttributes(model, "Wrong login or password!");
            return false;
        }
        session.setAttribute("email", user.getEmail());
        return true;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> find(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
