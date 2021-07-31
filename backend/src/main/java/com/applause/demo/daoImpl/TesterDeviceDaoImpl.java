package com.applause.demo.daoImpl;

import com.applause.demo.dao.TesterDeviceDao;
import com.applause.demo.entity.TesterDevice;
import com.applause.demo.repository.TesterDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TesterDeviceDaoImpl implements TesterDeviceDao {
    @Autowired
    private TesterDeviceRepository testerDeviceRepository;

    @Override
    public void save(TesterDevice td){
        testerDeviceRepository.save(td);
    }
}
