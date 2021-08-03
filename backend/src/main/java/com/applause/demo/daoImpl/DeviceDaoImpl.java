package com.applause.demo.daoImpl;

import com.applause.demo.dao.DeviceDao;
import com.applause.demo.entity.Devices;
import com.applause.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceDaoImpl implements DeviceDao {
    @Autowired
    private DeviceRepository deviceRepository;

    public void save(Devices device){
        deviceRepository.save(device);
    }

    public Page<Devices> findAll(int page){
        return deviceRepository.findAll(PageRequest.of(page,5));
    }
}
