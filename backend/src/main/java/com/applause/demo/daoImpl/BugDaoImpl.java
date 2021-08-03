package com.applause.demo.daoImpl;

import com.applause.demo.dao.BugDao;
import com.applause.demo.entity.Bugs;
import com.applause.demo.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BugDaoImpl implements BugDao {
    @Autowired
    private BugRepository bugRepository;
    public void save(Bugs bug){
        bugRepository.save(bug);
    }

    @Override
    public List<Object[]> search(String[] countries, String[] devices){
        // All countries and All devices
        if(countries.length == 0 && devices.length == 0){
            System.out.println("All, All");
            return bugRepository.findWithAllCountriesAndAllDevices();
        }
        // All countries variable devices
        else if(countries.length == 0 && devices.length != 0){
            System.out.println("All, SOME");
            return bugRepository.findWithAllCountriesAndSomeDevices(devices);
        }
        else if(countries.length != 0 && devices.length == 0){
            System.out.println("SOME, All");
            return bugRepository.findWithSomeCountriesAndAllDevices(countries);
        }
        // List of countries and devices
        else{
            System.out.println("SOME, SOME");
            return bugRepository.findWithSomeCountriesAndSomeDevices(countries,devices);
        }
    }
}
