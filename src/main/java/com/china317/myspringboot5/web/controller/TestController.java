package com.china317.myspringboot5.web.controller;

import com.china317.myspringboot5.entity.main.Person;
import com.china317.myspringboot5.repository.main.PersonDao;
import com.china317.myspringboot5.repository.second.SecondDao;
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
    PersonDao personDao;
    @Autowired
    SecondDao secondDao;

    @RequestMapping(value={"/","/index"})
    public ResponseMassage index(){
        return ResponseMassage.newSuccessMsg("Welcome!");
    }

    @RequestMapping(value={"/person/save"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage insertPerson(@RequestBody Person person, HttpServletRequest request){
        return ResponseMassage.newSuccessMsg(personDao.save(person));
    }

    @RequestMapping(value={"/person/findAll"}, consumes= MediaType.JSON_UTF_8)
    public ResponseMassage queryAllPerson(){
        return ResponseMassage.newSuccessMsg(personDao.findAll());
    }
}
