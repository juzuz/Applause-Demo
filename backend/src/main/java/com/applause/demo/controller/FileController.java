package com.applause.demo.controller;

import com.applause.demo.service.FileService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import javax.transaction.Transactional;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/uploadFile")
    public ResponseEntity<JSONObject> uploadFiles(@RequestParam(value = "tester",required = false) MultipartFile tester,
                                                  @RequestParam(value = "devices",required = false) MultipartFile devices,
                                                  @RequestParam(value = "test_device",required = false) MultipartFile tester_device,
                                                  @RequestParam(value = "bugs", required = false) MultipartFile bugs
    ){
        // Sometimes null doesn't capture. Multipart file headers may cause it not to be null
        // Therefore check the actual file size.
        JSONObject responseObj = new JSONObject();
        JSONObject testerObj = new JSONObject();
        JSONObject deviceObj = new JSONObject();
        JSONObject testerDeviceObj = new JSONObject();
        JSONObject bugObj = new JSONObject();

        try{
            if(tester != null && tester.getSize() > 0)
                testerObj = fileService.uploadTesters(tester);
            if(devices!= null && devices.getSize()>0)
                deviceObj = fileService.uploadDevices(devices);
            if(tester_device != null && tester_device.getSize()>0)
                testerDeviceObj = fileService.uploadTesterDevice(tester_device);
            if(bugs != null && bugs.getSize()>0)
                bugObj = fileService.uploadBugs(bugs);
        }
        catch (Exception e){
            JSONObject ob = new JSONObject();
            ob.put("status",499);
            ob.put("exception",e.toString());
            return new ResponseEntity<JSONObject>(ob, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        responseObj.put("tester",testerObj);
        responseObj.put("device",deviceObj);
        responseObj.put("tester_device",testerDeviceObj);
        responseObj.put("bug",bugObj);

        return new ResponseEntity<JSONObject>(responseObj, HttpStatus.OK);
    }
}
