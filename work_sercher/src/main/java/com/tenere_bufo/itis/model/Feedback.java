package com.tenere_bufo.itis.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Entity(name = "feedback")
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;
}
