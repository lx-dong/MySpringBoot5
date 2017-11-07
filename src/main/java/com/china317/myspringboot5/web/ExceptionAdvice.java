package com.china317.myspringboot5.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lx-dong on 2017/11/7.
 */
//@RestController
//@ControllerAdvice("com.china317.myspringboot5.web.controller")
// 可捕获非404 异常
public class ExceptionAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex){
        HttpStatus status = getStatus(request);
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("url", request.getRequestURL());
        msg.put("status", status.value());

        if(HttpStatus.INTERNAL_SERVER_ERROR.equals(status)){
            msg.put("msg", "server error");
        }else{
            msg.put("msg", ex.getMessage());
        }

        return new ResponseEntity<>(ResponseMassage.newErrorMsg(msg), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("att1","att1Value");
        System.out.println("@ModelAttribute --model=" + model);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        Map<String, Object> model = binder.getBindingResult().getModel();
        System.out.println("@initBinder --model=" + model);

    }

}
