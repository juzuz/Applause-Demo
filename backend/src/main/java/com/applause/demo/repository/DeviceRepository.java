package com.applause.demo.repository;

import com.applause.demo.entity.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository  extends JpaRepository<Devices, Integer> {
}
