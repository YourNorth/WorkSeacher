package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.FeedbackForEmployer;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackForEmployerService {
    FeedbackForEmployer save(FeedbackForEmployer feedbackForEmployer);
}
