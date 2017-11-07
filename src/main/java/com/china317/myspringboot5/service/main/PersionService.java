package com.china317.myspringboot5.service.main;

import com.china317.myspringboot5.entity.main.Person;
import com.china317.myspringboot5.repository.main.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by lx-dong on 2017/11/6.
 */
@Service
@Transactional
public class PersionService {
    @Autowired
    PersonDao personDao;

    public Person save(Person person){
        return personDao.save(person);
    }

    public Iterable<Person> findAll(){
        return personDao.findAll();
    }

    public boolean transactionTest(){
        personDao.deleteAll();
        int a = 1/0;
        personDao.save(new Person());
        return true;
    }

    public void test(int a){

    }
}
