package com.applause.demo.serviceImpl;

import com.applause.demo.dao.TesterDao;
import com.applause.demo.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TesterServiceImpl implements TesterService {
    @Autowired
    private TesterDao testerDao;


    @Override
    public List<String> getCountries(){
        return testerDao.getCountries();
    }
}
