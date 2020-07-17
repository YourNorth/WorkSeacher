package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.config.SenderConfig;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.services.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAsync
public class EmailServiceImpl implements EmailService {

    @Autowired
    private SenderConfig sender;

    @Value("${email.subject}")
    private String subjectEmail;

    @Value("${email.textRight}")
    private String textRight;

    @Value("${email.textWrong}")
    private String textWrong;

    @Override
    public void sendConfirmation(User user) {
        String mailText = "<a href='http://localhost:8080/token/" + user.getToken() + "'>" + textRight + "</a>";

        sender.send(subjectEmail, mailText, user.getEmail());
        log.info("The user with this mail sent a confirmation message: " + user.getEmail());
    }
}
