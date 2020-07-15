package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.FeedbackForCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackForCandidateRepository extends JpaRepository<FeedbackForCandidate, Long> {
}
