package ru.springsecurity.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "skills")
public class Skill extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    private Set<User> users;
}
