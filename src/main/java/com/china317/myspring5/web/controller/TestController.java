package com.china317.myspring5.web.controller;

import com.china317.myspring5.util.MediaType;
import com.china317.myspring5.web.ResponseMassage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lx-dong on 2017/11/3.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class TestController {
    @RequestMapping(value={"/","/index"},consumes = MediaType.JSON_UTF_8)
    public ResponseMassage index(){
        return ResponseMassage.newSuccessMsg("Hello World!");
    }


}
