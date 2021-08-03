package com.applause.demo.daoImpl;

import com.applause.demo.dao.TesterDao;
import com.applause.demo.entity.Testers;
import com.applause.demo.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;



@Repository
public class TesterDaoImpl implements TesterDao {
    @Autowired
    TesterRepository testerRepository;
    @Override
    public void save(Testers tester){
        testerRepository.save(tester);
    }

    @Override
    public Page<String> getCountries(int page){
        return testerRepository.findAllDistinctByCountry(PageRequest.of(page,10));
    }



}
