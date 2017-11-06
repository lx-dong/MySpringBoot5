package com.china317.myspringboot5.entity.second;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lx-dong on 2017/11/6.
 */
@Entity
@Table(name="second")
public class Second implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
