package ru.springsecurity.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "company")
public class Company extends BaseEntity{

    @Column(name = "name")
    private String name;

    private Set<String> vacancies;
}
