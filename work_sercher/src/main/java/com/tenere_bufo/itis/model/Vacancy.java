package com.tenere_bufo.itis.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@Data
public class Vacancy extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
