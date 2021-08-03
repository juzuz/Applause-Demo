package com.applause.demo.utils;

import net.sf.json.JSONObject;

public class ResponseBuilder {

    private int status;
    private long row;
    private String exception = "";
    private String value;
    private String fileName;

    public ResponseBuilder(){};

    public ResponseBuilder(int status, long row, String value, String fileName){
        this.status =status;
        this.row = row;
        this.value = value;
        this.fileName = fileName;
    };

    public JSONObject getErrorResponse(){
        JSONObject obj = new JSONObject();
        obj.put("status",status);
        obj.put("row",row);
        obj.put("exception",exception);
        obj.put("value",value);
        obj.put("file",fileName);
        return obj;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
