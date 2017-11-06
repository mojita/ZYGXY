package com.lqkj.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/5.
 *
 */
@Entity
@Table(name = "admin_role")
public class AdminRole {

    @Id
    @GeneratedValue
    private Integer id;             //id
    private Integer role_id;        //角色id
    private Integer admin_id;       //超级管理员id

    public AdminRole() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
}
