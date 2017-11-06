package com.lqkj.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by lijunhong on 17/11/5.
 */
@Entity
@Table
public class Test {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;

    public Test() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
