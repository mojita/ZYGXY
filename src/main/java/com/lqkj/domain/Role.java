package com.lqkj.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/5.
 * 角色
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Integer role_id;    //角色id
    private String role_name;   //角色名
    private String description; //角色描述

    public Role() {}

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
