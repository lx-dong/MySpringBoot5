package com.china317.myspringboot5.web.controller;

import com.china317.myspringboot5.entity.main.Person;
import com.china317.myspringboot5.entity.second.Second;
import com.china317.myspringboot5.repository.main.PersonDao;
import com.china317.myspringboot5.repository.second.SecondDao;
import com.china317.myspringboot5.service.main.PersionService;
import com.china317.myspringboot5.service.second.SecondService;
import com.china317.myspringboot5.util.MediaType;
import com.china317.myspringboot5.web.ResponseMassage;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lx-dong on 2017/11/3.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    PersionService persionService;
    @Autowired
    SecondService secondService;

    @RequestMapping(value={"/","/index"})
    public ResponseMassage index(){
        return ResponseMassage.newSuccessMsg("Welcome!");
    }

    @RequestMapping(value={"/person/save"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage savePerson(@RequestBody Person person, HttpServletRequest request){
        return ResponseMassage.newSuccessMsg(persionService.save(person));
    }

    @RequestMapping(value={"/person/findAll"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage findAllPerson(){
        return ResponseMassage.newSuccessMsg(persionService.findAll());
    }

    @RequestMapping(value={"/person/transactionTest"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage transactionTestPerson(){
        return ResponseMassage.newSuccessMsg(persionService.transactionTest());
    }

    @RequestMapping(value={"/second/save"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage saveSecond(@RequestBody Second second, HttpServletRequest request){
        return ResponseMassage.newSuccessMsg(secondService.save(second));
    }

    @RequestMapping(value={"/second/findAll"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage findAllSecond(){
        return ResponseMassage.newSuccessMsg(secondService.findAll());
    }

    @RequestMapping(value={"/second/crossDBTest"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage crossDBTest(){
        return ResponseMassage.newSuccessMsg(secondService.crossDBTest());
    }

    @RequestMapping(value={"/person/test"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage test(){
        persionService.test(1);
        return ResponseMassage.newSuccessMsg(null);
    }


}
