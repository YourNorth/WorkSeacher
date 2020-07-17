package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.dto.AuthenticationRequestDto;
import com.tenere_bufo.itis.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void register(User user, String captchaResponse);

    boolean confirm(String token, ModelMap model);

    List<User> findAll();

    Optional<User> find(String email);

    void delete(User user);

    void add(User user);

    void updateStatus(User user);

    Optional<User> findByToken(String token);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
