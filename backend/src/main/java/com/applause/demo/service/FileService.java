package com.applause.demo.service;
import com.applause.demo.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public void uploadTesters(MultipartFile testers) throws IOException;
    public void uploadDevices(MultipartFile devices) throws IOException;
    public void uploadBugs(MultipartFile bugs) throws IOException;
    public void uploadTesterDevice(MultipartFile tester_device) throws IOException;
}
