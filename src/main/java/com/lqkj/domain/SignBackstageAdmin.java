package com.lqkj.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/5.
 */
@Entity
@Table(name = "sign_backstage_admin")
public class SignBackstageAdmin {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String phone_num;
    private String code;

    public SignBackstageAdmin() {}


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

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
