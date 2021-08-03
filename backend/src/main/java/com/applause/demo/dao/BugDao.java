package com.applause.demo.dao;

import com.applause.demo.entity.Bugs;

import java.util.List;

public interface BugDao {
    public void save(Bugs bug);
    public List<Object[]> search(String[] countries, String[] devices);

}
