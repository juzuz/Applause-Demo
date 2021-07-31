package com.applause.demo.entity;
import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@Table(name = "bugs")
public class Bugs {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private Integer testerId;
    private Integer deviceId;

    Bugs(){}

    public Bugs(Integer testerId, Integer deviceId){
        this.testerId = testerId;
        this.deviceId = deviceId;
    }
}

