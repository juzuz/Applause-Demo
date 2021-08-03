package com.applause.demo.service;
import com.applause.demo.entity.*;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    // Individual uploaders
    // On data errors, it will upload everything before the incorrect one.
    public JSONObject uploadTesters(MultipartFile testers) throws IOException;
    public JSONObject uploadDevices(MultipartFile devices) throws IOException;
    public JSONObject uploadBugs(MultipartFile bugs) throws IOException;
    public JSONObject uploadTesterDevice(MultipartFile tester_device) throws IOException;
}
