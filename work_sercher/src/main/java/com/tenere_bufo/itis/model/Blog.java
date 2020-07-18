package com.tenere_bufo.itis.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "blogs")
public class Blog extends BaseEntity{

    @Column(name = "day")
    private Integer day;

    @Column(name = "month")
    private String month;

    @Column(name = "name")
    private String name;

    @Column(name = "head_text")
    private String head_text;

    @Column(name = "topic")
    private String topic;

    @Column(name = "text", length = 10000)
    private String text;
}
