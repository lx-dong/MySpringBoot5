package com.china317.myspringboot5.service.second;

import com.china317.myspringboot5.entity.second.Second;
import com.china317.myspringboot5.repository.main.PersonDao;
import com.china317.myspringboot5.repository.second.SecondDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lx-dong on 2017/11/7.
 */
@Service
@Transactional
public class SecondService {
    @Autowired
    SecondDao secondDao;
    @Autowired
    PersonDao personDao;

    public Second save(Second second){
        return secondDao.save(second);
    }

    public Iterable<Second> findAll(){
        return secondDao.findAll();
    }

    public boolean crossDBTest(){
        personDao.delete(1L);
        int error = 1/0;
        Second second = new Second();
        second.setName("crossSave");
        second.setValue("232");
        secondDao.save(second);
        return true;
    }
}
