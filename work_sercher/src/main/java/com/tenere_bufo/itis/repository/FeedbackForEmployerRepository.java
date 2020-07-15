package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.FeedbackForEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackForEmployerRepository extends JpaRepository<FeedbackForEmployer, Long> {
}
