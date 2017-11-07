package com.lqkj.domain.vo;

import java.util.Date;

/**
 * 正在进行的签到视图实体
 */

public class ViewPublicSignNow {
    private Integer id;                 //发起id
    private String sponsor_name;        //发起人姓名
    private String sponsor_code;        //发起人工号,学号
    private String sign_in_name;        //签到名
    private String sign_in_classify;    //签到分类名
    private String starttime;           //开始时间
    private String endtime;             //结束时间
    private Integer sign_in_repetition; //重复
    private String custom_repetition;   //重复记录字段
    private boolean is_sign_out;        //是否签退
    private Date createtime;            //创建时间
    private String sign_place_name;     //签到地点
    private float longitude;            //经度
    private float latitude;             //纬度
    private Integer sign_in_scope;      //签到范围m
    private Integer classify_id;        //分类id
    private String description;         //描述
    private boolean is_open;            //是否开启签到
    private Integer message_status;     //发消息0(全校)1(学生)2(老师)
    private String code;                  //推送tag

    public ViewPublicSignNow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSponsor_name() {
        return sponsor_name;
    }

    public void setSponsor_name(String sponsor_name) {
        this.sponsor_name = sponsor_name;
    }

    public String getSponsor_code() {
        return sponsor_code;
    }

    public void setSponsor_code(String sponsor_code) {
        this.sponsor_code = sponsor_code;
    }

    public String getSign_in_name() {
        return sign_in_name;
    }

    public void setSign_in_name(String sign_in_name) {
        this.sign_in_name = sign_in_name;
    }

    public String getSign_in_classify() {
        return sign_in_classify;
    }

    public void setSign_in_classify(String sign_in_classify) {
        this.sign_in_classify = sign_in_classify;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getSign_in_repetition() {
        return sign_in_repetition;
    }

    public void setSign_in_repetition(Integer sign_in_repetition) {
        this.sign_in_repetition = sign_in_repetition;
    }

    public String getCustom_repetition() {
        return custom_repetition;
    }

    public void setCustom_repetition(String custom_repetition) {
        this.custom_repetition = custom_repetition;
    }

    public boolean isIs_sign_out() {
        return is_sign_out;
    }

    public void setIs_sign_out(boolean is_sign_out) {
        this.is_sign_out = is_sign_out;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSign_place_name() {
        return sign_place_name;
    }

    public void setSign_place_name(String sign_place_name) {
        this.sign_place_name = sign_place_name;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public Integer getSign_in_scope() {
        return sign_in_scope;
    }

    public void setSign_in_scope(Integer sign_in_scope) {
        this.sign_in_scope = sign_in_scope;
    }

    public Integer getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(Integer classify_id) {
        this.classify_id = classify_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    public Integer getMessage_status() {
        return message_status;
    }

    public void setMessage_status(Integer message_status) {
        this.message_status = message_status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
