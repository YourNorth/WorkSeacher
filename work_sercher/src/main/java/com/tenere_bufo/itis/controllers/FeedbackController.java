package com.tenere_bufo.itis.controllers;

import com.tenere_bufo.itis.model.Feedback;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String addFeedback(Feedback feedback){
        feedback.setStatus(State.ACTIVE);
        feedback.setCreated(new Date());
        feedback.setUpdated(new Date());
        feedbackRepository.save(feedback);
        return "contact";
    }
}
