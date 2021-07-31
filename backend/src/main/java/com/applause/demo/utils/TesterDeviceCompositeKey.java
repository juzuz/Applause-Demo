package com.applause.demo.utils;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TesterDeviceCompositeKey implements Serializable {
    private Integer testerId;
    private Integer deviceId;

    public TesterDeviceCompositeKey(){};
    public TesterDeviceCompositeKey(Integer t_id,Integer d_id){
        this.testerId = t_id;
        this.deviceId = d_id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(testerId, deviceId);
    }
}
