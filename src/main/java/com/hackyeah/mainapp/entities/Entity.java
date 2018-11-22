package com.hackyeah.mainapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Getter
@Setter
@Table(name = "NOTE")
@javax.persistence.Entity
public class Entity{

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "TEXT")
    private String text;
}