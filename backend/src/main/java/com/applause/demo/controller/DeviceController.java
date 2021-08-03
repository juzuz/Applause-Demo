package com.applause.demo.controller;

import com.applause.demo.entity.Devices;
import com.applause.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;


@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Transactional
    @GetMapping("/getDevices/{page}")
    public ResponseEntity<Page<Devices>> getDevices(@PathVariable(value = "page") int page){
        Page<Devices> deviceList = deviceService.getDevices(page);
        return new ResponseEntity<Page<Devices>>(deviceList, HttpStatus.OK);
    }
}
