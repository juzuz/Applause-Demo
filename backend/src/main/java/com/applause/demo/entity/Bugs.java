package com.applause.demo.entity;
import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@Table(name = "bugs")
public class Bugs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer deviceId;
    private Integer testerId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testerId",insertable = false,updatable = false)
    private Testers tester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deviceId",insertable = false,updatable = false)
    private Devices device;

    Bugs(){}

    public Bugs(Integer deviceId, Integer testerId){
        this.testerId = testerId;
        this.deviceId = deviceId;
    }
}

