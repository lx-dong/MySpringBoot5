package com.china317.myspringboot5.repository.main;

import com.china317.myspringboot5.entity.main.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lx-dong on 2017/11/6.
 */
public interface PersonDao extends CrudRepository<Person, Long> {

}
