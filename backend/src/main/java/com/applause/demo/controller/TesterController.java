package com.applause.demo.controller;

import com.applause.demo.entity.Testers;
import com.applause.demo.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
public class TesterController {

    @Autowired
    private TesterService testerService;

    @Transactional
    @GetMapping("/getCountries/{page}")
    public ResponseEntity<Page<String>> getCountries(@PathVariable(value = "page") int page){
        return new ResponseEntity<Page<String>>(testerService.getCountries(page),HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/search")
    public ResponseEntity<List<Object[]>> searchByFilter(@RequestParam("country") String countries, @RequestParam("device") String devices){
        String[] cList;String[] dList;
        if(countries.equals("ALL") || countries.isEmpty())
            cList = new String[0];
        else
            cList = countries.split(",");

        if(devices.equals("ALL") || devices.isEmpty())
            dList = new String[0];
        else
            dList = devices.split(",");
        return new ResponseEntity<List<Object[]>>(testerService.search(cList,dList), HttpStatus.OK);
    }
}
