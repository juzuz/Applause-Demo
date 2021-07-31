package com.applause.demo.serviceImpl;
import com.applause.demo.dao.BugDao;
import com.applause.demo.dao.DeviceDao;
import com.applause.demo.dao.TesterDao;
import com.applause.demo.dao.TesterDeviceDao;
import com.applause.demo.entity.Bugs;
import com.applause.demo.entity.Devices;
import com.applause.demo.entity.TesterDevice;
import com.applause.demo.entity.Testers;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applause.demo.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.sql.Timestamp;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private TesterDao testerDao;

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private BugDao bugDao;

    @Autowired
    private TesterDeviceDao testerDeviceDao;
    @Override
    public void uploadTesters(MultipartFile testers) throws IOException {
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(testers.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            else{
                Timestamp ts = java.sql.Timestamp.valueOf( csvRecord.get(4) );
                Testers newTester = new Testers(csvRecord.get(1),csvRecord.get(2),csvRecord.get(3),ts);
                testerDao.save(newTester);
            }
        }
    }

    @Override
    public void uploadDevices(MultipartFile devices) throws IOException{
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(devices.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            else{
                Devices newDevices = new Devices(csvRecord.get(1));
                deviceDao.save(newDevices);
            }
        }
    }

    @Override
    public void uploadBugs(MultipartFile devices) throws IOException{
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(devices.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            else{
                Bugs newBugs = new Bugs(Integer.parseInt(csvRecord.get(1)),Integer.parseInt(csvRecord.get(2)));
                bugDao.save(newBugs);
            }
        }
    }

    public void uploadTesterDevice(MultipartFile tester_device) throws IOException{
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(tester_device.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            else{
                TesterDevice newTesterDevice = new TesterDevice(Integer.parseInt(csvRecord.get(0)),Integer.parseInt(csvRecord.get(1)));
                testerDeviceDao.save(newTesterDevice);
            }
        }
    }
}
