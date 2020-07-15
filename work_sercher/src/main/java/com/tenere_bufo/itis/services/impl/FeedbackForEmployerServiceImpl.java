package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.model.FeedbackForEmployer;
import com.tenere_bufo.itis.repository.FeedbackForEmployerRepository;
import com.tenere_bufo.itis.services.FeedbackForEmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackForEmployerServiceImpl implements FeedbackForEmployerService {

    private final FeedbackForEmployerRepository feedbackForEmployerRepository;

    @Autowired
    public FeedbackForEmployerServiceImpl(FeedbackForEmployerRepository feedbackForEmployerRepository) {
        this.feedbackForEmployerRepository = feedbackForEmployerRepository;
    }

    @Override
    public FeedbackForEmployer save(FeedbackForEmployer feedbackForEmployer) {
        return feedbackForEmployerRepository.save(feedbackForEmployer);
    }
}
