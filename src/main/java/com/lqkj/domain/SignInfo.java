package com.lqkj.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lijunhong on 17/11/6.
 */
@Entity
@Table(name = "sign_in_info")
public class SignInfo {

    @Id
    @GeneratedValue
    private Integer id;                 //签到id
    private String name;                //姓名
    private String code;                //工号、学号
    private String sign_name;           //签到名字
    private String sign_classify;       //签到类型名字
    private String sign_place_name;     //签到地点名字
    private float sign_longitude;       //经度
    private float sign_latitude;        //纬度
    private Date sign_starttime;        //签到开始时间
    private Date sign_endtime;          //签到结束时间
    private Integer sign_classify_id;   //签到类型id
    private String academic_code;       //院系id
    private String org_code;            //组织机构code
    private String class_code;          //班级code
    private String major_code;          //专业code
    private boolean is_late;            //是否迟到
    private Integer late_time;          //迟到时间(分钟)
    private boolean is_leave_early;     //是否早退
    private Integer leave_early_time;   //早退时间
    private Integer sponsor_id;         //发起人id
    private int is_teacher;             //是否为老师1(老师)2(学生)
    //TODO 这里增加了一个字段

    public SignInfo() {}

    public int getIs_teacher() {
        return is_teacher;
    }

    public void setIs_teacher(int is_teacher) {
        this.is_teacher = is_teacher;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSign_name() {
        return sign_name;
    }

    public void setSign_name(String sign_name) {
        this.sign_name = sign_name;
    }

    public String getSign_classify() {
        return sign_classify;
    }

    public void setSign_classify(String sign_classify) {
        this.sign_classify = sign_classify;
    }

    public String getSign_place_name() {
        return sign_place_name;
    }

    public void setSign_place_name(String sign_place_name) {
        this.sign_place_name = sign_place_name;
    }

    public float getSign_longitude() {
        return sign_longitude;
    }

    public void setSign_longitude(float sign_longitude) {
        this.sign_longitude = sign_longitude;
    }

    public float getSign_latitude() {
        return sign_latitude;
    }

    public void setSign_latitude(float sign_latitude) {
        this.sign_latitude = sign_latitude;
    }

    public Date getSign_starttime() {
        return sign_starttime;
    }

    public void setSign_starttime(Date sign_starttime) {
        this.sign_starttime = sign_starttime;
    }

    public Date getSign_endtime() {
        return sign_endtime;
    }

    public void setSign_endtime(Date sign_endtime) {
        this.sign_endtime = sign_endtime;
    }

    public Integer getSign_classify_id() {
        return sign_classify_id;
    }

    public void setSign_classify_id(Integer sign_classify_id) {
        this.sign_classify_id = sign_classify_id;
    }

    public String getAcademic_code() {
        return academic_code;
    }

    public void setAcademic_code(String academic_code) {
        this.academic_code = academic_code;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public boolean is_late() {
        return is_late;
    }

    public void setIs_late(boolean is_late) {
        this.is_late = is_late;
    }

    public Integer getLate_time() {
        return late_time;
    }

    public void setLate_time(Integer late_time) {
        this.late_time = late_time;
    }

    public boolean is_leave_early() {
        return is_leave_early;
    }

    public void setIs_leave_early(boolean is_leave_early) {
        this.is_leave_early = is_leave_early;
    }

    public Integer getLeave_early_time() {
        return leave_early_time;
    }

    public void setLeave_early_time(Integer leave_early_time) {
        this.leave_early_time = leave_early_time;
    }

    public Integer getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(Integer sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    @Override
    public String toString() {
        return "SignInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", sign_name='" + sign_name + '\'' +
                ", sign_classify='" + sign_classify + '\'' +
                ", sign_place_name='" + sign_place_name + '\'' +
                ", sign_longitude=" + sign_longitude +
                ", sign_latitude=" + sign_latitude +
                ", sign_starttime=" + sign_starttime +
                ", sign_endtime=" + sign_endtime +
                ", sign_classify_id=" + sign_classify_id +
                ", academic_code='" + academic_code + '\'' +
                ", org_code='" + org_code + '\'' +
                ", class_code='" + class_code + '\'' +
                ", major_code='" + major_code + '\'' +
                ", is_late=" + is_late +
                ", late_time=" + late_time +
                ", is_leave_early=" + is_leave_early +
                ", leave_early_time=" + leave_early_time +
                ", sponsor_id=" + sponsor_id +
                '}';
    }
}
