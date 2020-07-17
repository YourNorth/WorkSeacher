package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.model.Feedback;
import com.tenere_bufo.itis.repository.FeedbackRepository;
import com.tenere_bufo.itis.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
