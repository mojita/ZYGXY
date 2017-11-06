package com.lqkj.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/5.
 *
 */
@Entity
@Table(name = "sign_in_classify")
public class SignInClassify {

    @Id
    @GeneratedValue
    private Integer id;                 //类型id
    private String type_name;           //分类名
    private String creater_id;          //创建人工号或学号
    private String creater_name;        //创建人姓名
    private String sign_image_url;      //签到图标路径
    private String show_image_url;      //显示图标路径
    private Integer late_determine;     //迟到判定时间(分钟)
    private Integer early_determine;    //早退判定时间(分钟)
    private Integer sign_in_interval;   //签退间隔时间,分钟
    private Date create_time;           //创建时间
    private Integer sign_in_scope;       //有效签到距离
    private boolean is_open;            //是否打开应用


    public SignInClassify() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getCreater_id() {
        return creater_id;
    }

    public void setCreater_id(String creater_id) {
        this.creater_id = creater_id;
    }

    public String getCreater_name() {
        return creater_name;
    }

    public void setCreater_name(String creater_name) {
        this.creater_name = creater_name;
    }

    public String getSign_image_url() {
        return sign_image_url;
    }

    public void setSign_image_url(String sign_image_url) {
        this.sign_image_url = sign_image_url;
    }

    public String getShow_image_url() {
        return show_image_url;
    }

    public void setShow_image_url(String show_image_url) {
        this.show_image_url = show_image_url;
    }

    public Integer getLate_determine() {
        return late_determine;
    }

    public void setLate_determine(Integer late_determine) {
        this.late_determine = late_determine;
    }

    public Integer getEarly_determine() {
        return early_determine;
    }

    public void setEarly_determine(Integer early_determine) {
        this.early_determine = early_determine;
    }

    public Integer getSign_in_interval() {
        return sign_in_interval;
    }

    public void setSign_in_interval(Integer sign_in_interval) {
        this.sign_in_interval = sign_in_interval;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public boolean is_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    public Integer getSign_in_scope() {
        return sign_in_scope;
    }

    public void setSign_in_scope(Integer sign_in_scope) {
        this.sign_in_scope = sign_in_scope;
    }

    @Override
    public String toString() {
        return "SignInClassify{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", creater_id='" + creater_id + '\'' +
                ", creater_name='" + creater_name + '\'' +
                ", sign_image_url='" + sign_image_url + '\'' +
                ", show_image_url='" + show_image_url + '\'' +
                ", late_determine=" + late_determine +
                ", early_determine=" + early_determine +
                ", sign_in_interval=" + sign_in_interval +
                ", create_time=" + create_time +
                ", sign_in_scop=" + sign_in_scope +
                ", is_open=" + is_open +
                '}';
    }
}
