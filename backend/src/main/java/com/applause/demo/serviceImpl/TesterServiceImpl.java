package com.applause.demo.serviceImpl;

import com.applause.demo.dao.BugDao;
import com.applause.demo.dao.TesterDao;
import com.applause.demo.dao.TesterDeviceDao;
import com.applause.demo.entity.Testers;
import com.applause.demo.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TesterServiceImpl implements TesterService {
    @Autowired
    private TesterDao testerDao;

    @Autowired
    private BugDao bugDao;


    @Override
    public Page<String> getCountries(int page){
        return testerDao.getCountries(page);
    }

    @Override
    public List<Object[]> search(String[] countries, String[] devices){
        return bugDao.search(countries,devices);
    }
}
