package com.applause.demo.daoImpl;

import com.applause.demo.dao.TesterDao;
import com.applause.demo.entity.Testers;
import com.applause.demo.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TesterDaoImpl implements TesterDao {
    @Autowired
    TesterRepository testerRepository;
    @Override
    public void save(Testers tester){
        testerRepository.save(tester);
    }

    @Override
    public List<String> getCountries(){
        return testerRepository.findAllDistinctByCountry();
    }

}
