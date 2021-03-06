package com.tenere_bufo.itis.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "category")
    private String category;

    @Column(name = "experience")
    private String experience;

    @Column(name = "jobType")
    private String jobType;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "gender")
    private String gender;

    @Column(name = "link_img")
    private String link_img;

    @Column(name = "amount")
    private String amount;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Vacancy> vacancies;
}
