package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.dto.AuthenticationRequestDto;
import com.tenere_bufo.itis.dto.CaptchaResponseDto;
import com.tenere_bufo.itis.model.Role;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import com.tenere_bufo.itis.repository.UserRepository2;
import com.tenere_bufo.itis.services.RolesService;
import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private final RolesService rolesService;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RestTemplate restTemplate, UserRepository2 userRepository2, RolesService rolesService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.userRepository2 = userRepository2;
        this.rolesService = rolesService;
    }

    @Override
    public void register(User user, String captchaResponse) {
        Optional<Role> roleUser = rolesService.findByName("USER");
        if (roleUser.isPresent()) {
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(roleUser.get());
            user.setRoles(userRoles);
        }
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setStatus(State.ACTIVE);
        user.setToken(generateNewToken());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        User registeredUser = userRepository.save(user);
        log.info("IN register - user: {} successfully registered", registeredUser);
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
    public boolean signIn(AuthenticationRequestDto userForm, ModelMap model, HttpSession session, String captchaResponse) {
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (!Objects.requireNonNull(response).isSuccess()) {
            Attributes.addErrorAttributes(model, "Fill captcha!");
            return false;
        }
        Optional<User> user = find(userForm.getEmail());
        if (!user.isPresent() || !passwordEncoder.matches(userForm.getPassword(), user.get().getPassword())) {
            log.info("User with this email and password could not log in: " + userForm.getEmail() + " and " + userForm.getPassword());
            Attributes.addErrorAttributes(model, "Wrong login or password!");
            return false;
        }
        if (user.get().getStatus() == State.ACTIVE) {
            Attributes.addSuccessAttributes(model, "Success!");
            session.setAttribute("email", user.get().getEmail());
            log.info("User with this mail went to the site: " + userForm.getEmail());
            return true;
        }
        if (user.get().getStatus() == State.NOT_ACTIVE) {
            Attributes.addErrorAttributes(model, "Your account is inactive since you did not confirm your mail!");
            log.info("The user with this mail was not logged in as he did not confirm the mail: " + userForm.getEmail());
        }
        if (user.get().getStatus() == State.BANNED) {
            Attributes.addErrorAttributes(model, "Your account has been banned!");
            log.info("A user with this mail has not logged in as he is banned: " + userForm.getEmail());
        }
        if (user.get().getStatus() == State.DELETED) {
            Attributes.addErrorAttributes(model, "Your account has been deleted!");
            log.info("The user with this mail was not logged in as he was deleted: " + user.get().getEmail());
        }
        return false;
    }

    @Override
    @Transactional
    public boolean confirm(String token, ModelMap model, HttpSession session) {
        Optional<User> user = findByToken(token);
        if (user.isPresent()) {
            userRepository2.update(user.get());
            session.setAttribute("email", user.get().getEmail());
            log.info("A user with this mail has confirmed it: " + user.get().getEmail());
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

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
