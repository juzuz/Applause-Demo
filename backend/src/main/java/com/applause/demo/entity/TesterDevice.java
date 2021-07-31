package com.applause.demo.entity;

import com.applause.demo.utils.TesterDeviceCompositeKey;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@IdClass(TesterDeviceCompositeKey.class)
@Table(name = "tester_device")
public class TesterDevice {
    @Id
    private Integer testerId;
    @Id
    private Integer deviceId;

    public TesterDevice(){};

    public TesterDevice(Integer t_id,Integer d_id){
        this.testerId=t_id;
        this.deviceId=d_id;
    }
}
