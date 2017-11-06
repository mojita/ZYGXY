package com.lqkj.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/7.
 * 消息推送表
 */
@Entity
@Table(name = "sign_in_send_message")
public class SignInSendMessage {

    @Id
    @GeneratedValue
    private Integer id;         //id
    private String code;        //学号或工号
    private Integer sponsor_id; //发起id

    public SignInSendMessage() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(Integer sponsor_id) {
        this.sponsor_id = sponsor_id;
    }
}
