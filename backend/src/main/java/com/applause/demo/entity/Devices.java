
package com.applause.demo.entity;
import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;


    Devices(){};

    public Devices(String description){
        this.description = description;
    }
}


