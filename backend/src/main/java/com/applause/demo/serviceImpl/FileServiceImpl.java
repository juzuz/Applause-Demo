package com.applause.demo.serviceImpl;
import com.applause.demo.dao.BugDao;
import com.applause.demo.dao.DeviceDao;
import com.applause.demo.dao.TesterDao;
import com.applause.demo.dao.TesterDeviceDao;
import com.applause.demo.entity.Bugs;
import com.applause.demo.entity.Devices;
import com.applause.demo.entity.TesterDevice;
import com.applause.demo.entity.Testers;
import com.applause.demo.utils.ResponseBuilder;
import net.sf.json.JSONObject;
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
    public JSONObject uploadTesters(MultipartFile testers) throws IOException {
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(testers.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                .withHeader("testerId","firstName","lastName","country","lastLogin")
                .withIgnoreHeaderCase()
                .withTrim());

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if(csvRecord.getRecordNumber() == 1){
                continue;
            }
            ResponseBuilder rB = new ResponseBuilder(
                    400,
                    csvRecord.getRecordNumber(),
                    csvRecord.toString(),
                    "tester");
            try{
                if(csvRecord.isConsistent()){
                    Timestamp ts = java.sql.Timestamp.valueOf( csvRecord.get("lastLogin") );
                    Testers newTester = new Testers(csvRecord.get("firstName"),csvRecord.get("lastName"),csvRecord.get("country"),ts);
                    testerDao.save(newTester);
                }
                else{
                    rB.setException("You may have uploaded the wrong file!");
                    return rB.getErrorResponse();
                }
            }
            catch(Exception e){
                rB.setException(e.toString());
                return rB.getErrorResponse();
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("status",200);
        obj.put("file","tester");
        return obj;
    }

    @Override
    public JSONObject uploadDevices(MultipartFile devices) throws IOException{
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(devices.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                .withHeader("deviceId","description")
                .withIgnoreHeaderCase()
                .withTrim());

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            ResponseBuilder rB = new ResponseBuilder(
                    400,
                    csvRecord.getRecordNumber(),
                    csvRecord.toString(),
                    "device");
            try{

                if(csvRecord.isConsistent()){
                    Devices newDevices = new Devices(csvRecord.get(1));
                    deviceDao.save(newDevices);
                }
                else{
                    rB.setException("You may have uploaded the wrong file!");
                    return rB.getErrorResponse();
                }
            }
            catch(Exception e){
                rB.setException(e.toString());
                return rB.getErrorResponse();
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("status",200);
        obj.put("file","device");
        return obj;
    }

    @Override
    public JSONObject uploadBugs(MultipartFile devices) throws IOException{
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(devices.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                .withHeader("bugId","deviceId","testerId")
                .withIgnoreHeaderCase()
                .withTrim());

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            ResponseBuilder rB = new ResponseBuilder(
                    400,
                    csvRecord.getRecordNumber(),
                    csvRecord.toString(),
                    "bugs");
            try{
                if(csvRecord.isConsistent()){
                    Bugs newBugs = new Bugs(Integer.parseInt(csvRecord.get(1)),Integer.parseInt(csvRecord.get(2)));
                    bugDao.save(newBugs);
                }
                else{
                    rB.setException("You may need to upload device or tester before uploading this file!");
                    return rB.getErrorResponse();
                }
            }
            catch(Exception e){
                rB.setException(e.toString());
                return rB.getErrorResponse();
            }

        }
        JSONObject obj = new JSONObject();
        obj.put("status",200);
        obj.put("file","bugs");
        return obj;
    }

    public JSONObject uploadTesterDevice(MultipartFile tester_device) throws IOException{
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(tester_device.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                .withHeader("testerId","deviceId")
                .withIgnoreHeaderCase()
                .withTrim());
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (csvRecord.getRecordNumber() == 1){
                continue;
            }
            ResponseBuilder rB = new ResponseBuilder(
                    400,
                    csvRecord.getRecordNumber(),
                    csvRecord.toString(),
                    "bugs");
            try{
                if(csvRecord.isConsistent()){
                    TesterDevice newTesterDevice = new TesterDevice(Integer.parseInt(csvRecord.get(0)),Integer.parseInt(csvRecord.get(1)));
                    testerDeviceDao.save(newTesterDevice);
                }
                else{
                    rB.setException("You may need to upload device or tester before uploading this file!");
                    return rB.getErrorResponse();
                }
            }
            catch(Exception e){
                rB.setException(e.toString());
                return rB.getErrorResponse();
            }
        }
        JSONObject obj = new JSONObject();
        obj.put("status",200);
        obj.put("file","tester_device");
        return obj;
    }
}
