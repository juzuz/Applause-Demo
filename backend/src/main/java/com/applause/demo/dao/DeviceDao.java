package com.applause.demo.dao;

import com.applause.demo.entity.Devices;
import org.springframework.data.domain.Page;

public interface DeviceDao {
    public void save(Devices device);
    public Page<Devices> findAll(int page);
}
