package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.FeedbackForEmployer;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import com.tenere_bufo.itis.services.FeedbackForEmployerService;
import com.tenere_bufo.itis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
public class CandidatesController {

    private final UserService userService;
    private final FeedbackForEmployerService feedbackForEmployerService;

    @Autowired
    public CandidatesController(UserService userService, FeedbackForEmployerService feedbackForEmployerService) {
        this.userService = userService;
        this.feedbackForEmployerService = feedbackForEmployerService;
    }

    @GetMapping("/candidate/{id}")
    public String getUser(@PathVariable("id") Long id, Map<String, Object> model, HttpServletRequest request) {
        Optional<User> users = userService.findById(id);
        if (users.isPresent()) {
            model.put("users", Collections.singletonList(users.get()));
            if (request.isUserInRole("ROLE_USER"))
                return "candidate_details_less";
            if (request.isUserInRole("ROLE_EMPLOYER"))
                return "candidate_details";
            if (request.isUserInRole("ROLE_ADMIN"))
                return "candidate_details";
        }
        return "candidate";
    }

    @PostMapping("/candidate/{id}")
    public String toSendLetter(@PathVariable(name = "id") Long id, FeedbackForEmployer feedback, Authentication authentication) {
        feedback.setCreated(new Date());
        feedback.setUpdated(new Date());
        feedback.setStatus(State.ACTIVE);
        feedback.setUser_id(id);
        if (authentication != null) {
            User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
            feedback.setWorker_id(user.getId());
            feedbackForEmployerService.save(feedback);
        }
        return "redirect:/candidate/{id}";
    }
}
