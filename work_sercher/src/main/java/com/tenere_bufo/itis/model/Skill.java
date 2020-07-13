package com.tenere_bufo.itis.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
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
