package com.tenere_bufo.itis.services;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendConfirmation(String toEmail, String token);
}
