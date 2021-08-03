package com.applause.demo.repository;

import com.applause.demo.entity.TesterDevice;
import com.applause.demo.entity.Testers;
import com.applause.demo.utils.TesterDeviceCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TesterDeviceRepository extends JpaRepository<TesterDevice, TesterDeviceCompositeKey> {

}
