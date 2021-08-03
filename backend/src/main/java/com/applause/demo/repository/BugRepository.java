package com.applause.demo.repository;

import com.applause.demo.entity.Bugs;
import com.applause.demo.entity.Testers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BugRepository extends JpaRepository<Bugs,Integer> {
    @Query("select b.tester,count(b) from Bugs b group by b.tester order by count(b) desc")
    public List<Object[]> findWithAllCountriesAndAllDevices();

    @Query("select b.tester, count(b) from Bugs b where b.device.description in :devices group by b.tester order by count(b) desc")
    public List<Object[]> findWithAllCountriesAndSomeDevices(String[] devices);

    @Query("select b.tester, count(b) from Bugs b where b.tester.country in :countries group by b.tester order by count(b) desc")
    public List<Object[]> findWithSomeCountriesAndAllDevices(String[] countries);

    @Query("select b.tester,count(b) from Bugs b where b.tester.country in :countries AND b.device.description in :devices group by b.tester order by count(b) desc")
    public List<Object[]> findWithSomeCountriesAndSomeDevices(String[] countries, String[] devices);

}
