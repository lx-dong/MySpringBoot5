package com.china317.myspringboot5.web.controller;

import com.china317.myspringboot5.web.ResponseMessage;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lx-dong on 2017/10/31.
 */
@Controller
@RequestMapping("/error")
// 可捕获404 等异常
public class CustomErrorController implements ErrorController {

    @RequestMapping
    @ResponseBody
    ResponseEntity<?> error(HttpServletRequest request, Throwable ex){
        HttpStatus status = getStatus(request);
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("url", request.getRequestURL());
        msg.put("status", status.value());

        if(HttpStatus.INTERNAL_SERVER_ERROR.equals(status)){
            msg.put("msg", "server error");
        }else{
            msg.put("msg", status.getReasonPhrase());
        }

        return new ResponseEntity<>(ResponseMessage.newErrorMsg(msg), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
