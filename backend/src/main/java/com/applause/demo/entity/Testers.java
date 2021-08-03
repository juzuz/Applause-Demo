package com.applause.demo.entity;
import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "testers")
public class Testers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String country;
    private Timestamp lastLogin;


    public Testers(){};

    public Testers(String firstName, String lastName, String country, Timestamp lastLogin){
        this.firstName =firstName;
        this.lastName = lastName;
        this.country = country;
        this.lastLogin = lastLogin;
    };
}
