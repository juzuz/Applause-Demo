package com.applause.demo.repository;

import com.applause.demo.entity.Testers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TesterRepository  extends JpaRepository<Testers, Integer> {
    @Query("select distinct country from Testers")
    public Page<String> findAllDistinctByCountry(Pageable pageable);


}