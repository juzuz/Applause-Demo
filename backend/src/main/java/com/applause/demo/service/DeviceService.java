package com.applause.demo.service;

import com.applause.demo.entity.Devices;
import org.springframework.data.domain.Page;

public interface DeviceService {
    public Page<Devices> getDevices(int page);
}
