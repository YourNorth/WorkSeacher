package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.model.FeedbackForCandidate;
import com.tenere_bufo.itis.repository.FeedbackForCandidateRepository;
import com.tenere_bufo.itis.services.FeedbackForCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackForCandidateServiceImpl implements FeedbackForCandidateService {

    private final FeedbackForCandidateRepository feedbackForCandidateRepository;

    @Autowired
    public FeedbackForCandidateServiceImpl(FeedbackForCandidateRepository feedbackForCandidateRepository) {
        this.feedbackForCandidateRepository = feedbackForCandidateRepository;
    }

    @Override
    public FeedbackForCandidate save(FeedbackForCandidate feedbackForCandidate) {
        return feedbackForCandidateRepository.save(feedbackForCandidate);
    }
}
