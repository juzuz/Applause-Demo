package com.applause.demo.daoImpl;

import com.applause.demo.dao.BugDao;
import com.applause.demo.entity.Bugs;
import com.applause.demo.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BugDaoImpl implements BugDao {
    @Autowired
    private BugRepository bugRepository;
    public void save(Bugs bug){
        bugRepository.save(bug);
    }
}
