package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendConfirmation(User user);
}
