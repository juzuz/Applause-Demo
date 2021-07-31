
package com.applause.demo.entity;
import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private String description;

    Devices(){};

    public Devices(String description){
        this.description = description;
    }
}


