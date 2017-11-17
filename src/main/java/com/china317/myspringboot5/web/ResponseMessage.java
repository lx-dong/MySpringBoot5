package com.china317.myspringboot5.web;

/**
 * Created by lx-dong on 2017/11/3.
 */
public class ResponseMessage {
    public String status;
    public Object result;

    public ResponseMessage(){

    }

    public ResponseMessage(String status, Object result) {
        this.result = result;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static ResponseMessage newSuccessMsg(Object result){
        return new ResponseMessage("ok", result);
    }

    public static ResponseMessage newErrorMsg(Object result){
        return new ResponseMessage("error", result);
    }

}
