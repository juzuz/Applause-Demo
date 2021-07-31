package com.applause.demo.repository;

import com.applause.demo.entity.Bugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bugs,Integer> {
}
