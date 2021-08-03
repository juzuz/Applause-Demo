package com.applause.demo.dao;

import com.applause.demo.entity.Testers;
import org.springframework.data.domain.Page;



public interface TesterDao {
    public void save(Testers tester);
    public Page<String> getCountries(int page);
}
