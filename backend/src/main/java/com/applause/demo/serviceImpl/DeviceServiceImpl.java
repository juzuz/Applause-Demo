package com.applause.demo.serviceImpl;

import com.applause.demo.dao.DeviceDao;
import com.applause.demo.entity.Devices;
import com.applause.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public Page<Devices> getDevices(int page){
        return deviceDao.findAll(page);
    }
}
