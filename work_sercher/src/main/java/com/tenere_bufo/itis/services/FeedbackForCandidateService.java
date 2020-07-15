package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.FeedbackForCandidate;
import org.springframework.stereotype.Service;

@Service
public interface FeedbackForCandidateService {
    FeedbackForCandidate save(FeedbackForCandidate feedbackForCandidate);
}
