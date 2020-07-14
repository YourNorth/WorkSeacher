package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.dto.CaptchaResponseDto;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import com.tenere_bufo.itis.repository.UserRepository2;
import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Value("${recaptcha.secret}")
    private String secret;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;
    private final UserRepository2 userRepository2;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RestTemplate restTemplate, UserRepository2 userRepository2) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.userRepository2 = userRepository2;
    }

    @Override
    public void register(User user, String captchaResponse) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setStatus(State.NOT_ACTIVE);
        user.setToken(generateNewToken());
        add(user);
    }

    private static String generateNewToken() {
        int length = 500;
        Random r = new Random();
        return r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    @Override
    public boolean signIn(User userForm, ModelMap model, HttpSession session, String captchaResponse) {
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (!Objects.requireNonNull(response).isSuccess()) {
            Attributes.addErrorAttributes(model, "Fill captcha!");
            return false;
        }
        User user = userRepository.findByEmail(userForm.getEmail()).orElse(null);
        if (user == null || !passwordEncoder.matches(userForm.getPassword(), user.getPassword())) {
            String message = "User with this email and password could not log in: " + userForm.getEmail() + " and " + userForm.getPassword();
            log.info(message);
            Attributes.addErrorAttributes(model, "Wrong login or password!");
            return false;
        }
        if (user.getStatus() == State.ACTIVE) {
            Attributes.addSuccessAttributes(model, "Success!");
            session.setAttribute("email", user.getEmail());
            session.setAttribute("nickname", user.getNickname());
            log.info("User with this mail went to the site: " + user.getEmail());
            return true;
        }
        if (user.getStatus() == State.NOT_ACTIVE) {
            Attributes.addErrorAttributes(model, "Your account is inactive since you did not confirm your mail!");
            log.info("The user with this mail was not logged in as he did not confirm the mail: " + user.getEmail());
        }
        if (user.getStatus() == State.BANNED) {
            Attributes.addErrorAttributes(model, "Your account has been banned!");
            log.info("A user with this mail has not logged in as he is banned: " + user.getEmail());
        }
        if (user.getStatus() == State.DELETED) {
            Attributes.addErrorAttributes(model, "Your account has been deleted!");
            log.info("The user with this mail was not logged in as he was deleted: " + user.getEmail());
        }
        return false;
    }

    @Override
    @Transactional
    public boolean confirm(String token, ModelMap model, HttpSession session) {
        User user = findByToken(token).orElse(null);
        if (user != null) {
            userRepository2.update(user);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("nickname", user.getNickname());
            log.info("A user with this mail has confirmed it: " + user.getEmail());
            return true;
        } else {
            log.info("User attempt to confirm mail failed: " + token);
            return false;
        }
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
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateStatus(User user) {
        userRepository2.update(user);
    }

    @Override
    public Optional<User> findByToken(String token) {
        return userRepository.findByToken(token);
    }
}
