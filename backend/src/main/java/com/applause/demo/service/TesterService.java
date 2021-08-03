package com.applause.demo.service;

import com.applause.demo.entity.Testers;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TesterService {
    public Page<String> getCountries(int page);
    public List<Object[]> search(String[] countries,String[] devices);
}
