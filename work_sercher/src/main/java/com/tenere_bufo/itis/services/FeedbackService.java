package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.Feedback;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackService {
    Feedback save(Feedback feedback);
}
