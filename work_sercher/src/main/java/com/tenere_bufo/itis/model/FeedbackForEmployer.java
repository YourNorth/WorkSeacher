package com.tenere_bufo.itis.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;

@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedbackForEmployer")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackForEmployer extends BaseEntity{

    @Column(name = "worker_id")
    private Long worker_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "file")
    private File file;

    @Column(name = "cover_letter")
    private String cover_letter;
}
