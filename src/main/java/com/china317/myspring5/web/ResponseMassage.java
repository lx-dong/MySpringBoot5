package com.china317.myspring5.web;

/**
 * Created by lx-dong on 2017/11/3.
 */
public class ResponseMassage {
    public String status;
    public Object result;

    public ResponseMassage(){

    }

    public ResponseMassage(String status, Object result) {
        this.result = result;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static ResponseMassage newSuccessMsg(Object result){
        return new ResponseMassage("ok", result);
    }
}
