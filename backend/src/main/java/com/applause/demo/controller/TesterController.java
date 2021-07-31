package com.applause.demo.controller;

import com.applause.demo.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TesterController {

    @Autowired
    private TesterService testerService;


    @GetMapping("/getCountries")
    public @ResponseBody List<String> getCountries(){
        List<String> countries = testerService.getCountries();
        return countries;
    }
}
