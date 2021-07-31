package com.applause.demo.controller;

import com.applause.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFiles(@RequestParam("tester") MultipartFile tester,
                                              @RequestParam("devices") MultipartFile devices,
                                              @RequestParam("test_device") MultipartFile tester_device,
                                              @RequestParam("bugs") MultipartFile bugs
                                              ){
        try{
            fileService.uploadTesters(tester);
            fileService.uploadDevices(devices);
            fileService.uploadTesterDevice(tester_device);
            fileService.uploadBugs(bugs);

        }
        catch (Exception e){
            return new ResponseEntity<>("File Data Bad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Uploaded", HttpStatus.OK);
    }
}
