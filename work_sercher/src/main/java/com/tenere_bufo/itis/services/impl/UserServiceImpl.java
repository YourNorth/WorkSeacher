package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.dto.AuthenticationRequestDto;
import com.tenere_bufo.itis.dto.CaptchaResponseDto;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.repository.UserRepository;
import com.tenere_bufo.itis.repository.UserRepository2;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.RolesService;
import com.tenere_bufo.itis.services.UserService;
import com.tenere_bufo.itis.utils.Attributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final AuthenticationManager authenticationManager;


    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RestTemplate restTemplate, UserRepository2 userRepository2, RolesService rolesService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.userRepository2 = userRepository2;
        this.rolesService = rolesService;
        this.authenticationManager=authenticationManager;
    }

    @Override
    public void register(User user, String captchaResponse) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setStatus(State.ACTIVE);
        user.setToken(generateNewToken());
        user.setCreated(new Date());
        user.setUpdated(new Date());
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
    @Transactional
    public boolean confirm(String token, ModelMap model) {
        User user = findByToken(token).orElse(null);
        if (user != null) {
            userRepository2.update(user);
            UserDetailsImpl userDetails = new UserDetailsImpl(user);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())); //auth user
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

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
