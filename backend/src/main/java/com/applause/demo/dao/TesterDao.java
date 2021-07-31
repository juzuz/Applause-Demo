package com.applause.demo.dao;

import com.applause.demo.entity.Testers;

import java.util.List;

public interface TesterDao {
    public void save(Testers tester);
    public List<String> getCountries();
}
