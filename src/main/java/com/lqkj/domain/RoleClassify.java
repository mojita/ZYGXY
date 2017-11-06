package com.lqkj.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/6.
 * 角色和签到分类
 */
@Entity
@Table(name = "role_classify")
public class RoleClassify {

    @Id
    @GeneratedValue
    private Integer id;         //id
    private Integer role_id;    //角色id
    private Integer classify_id;//分类id

    public RoleClassify() {}

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

    public Integer getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(Integer classify_id) {
        this.classify_id = classify_id;
    }
}
