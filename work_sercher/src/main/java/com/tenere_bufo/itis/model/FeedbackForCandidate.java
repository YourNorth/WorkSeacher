package com.tenere_bufo.itis.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;

@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedbackForCandidate")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackForCandidate extends BaseEntity{

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "company_id")
    private Long company_id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "link_portfolio")
    private String link_portfolio;

    @Column(name = "file")
    private File file;

    @Column(name = "cover_letter")
    private String cover_letter;
}
