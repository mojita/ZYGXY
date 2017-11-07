package com.lqkj.domain.vo;

/**
 * Created by lijunhong on 17/11/7.
 */
public class SignListVO {

    private Integer id;                 //发起签到id
    private String sponsor_name;        //发起签到人工号/学号
    private String sponsor_code;        //发起签到人姓名
    private String sign_in_name;        //签到名
    private String sign_in_classify;    //签到分类名
    private String starttime;           //开始时间
    private String endtime;             //结束时间
    private boolean is_sign_out;        //是否退签
    private String sign_pace_name;      //签到地点
    private float longitude;            //经度
    private float latitude;             //纬度
    private Integer sign_in_scope;      //签到范围
    private int has_tip;                //是否包含签到人
    private float _distance;            //距离(离签到人的)
    private String sign_place_name;     //签到地点name
    private boolean is_open;            //是否打开应用

    public SignListVO() {}

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

    public boolean is_sign_out() {
        return is_sign_out;
    }

    public void setIs_sign_out(boolean is_sign_out) {
        this.is_sign_out = is_sign_out;
    }

    public String getSign_pace_name() {
        return sign_pace_name;
    }

    public void setSign_pace_name(String sign_pace_name) {
        this.sign_pace_name = sign_pace_name;
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

    public int getHas_tip() {
        return has_tip;
    }

    public void setHas_tip(int has_tip) {
        this.has_tip = has_tip;
    }

    public float get_distance() {
        return _distance;
    }

    public void set_distance(float _distance) {
        this._distance = _distance;
    }

    public String getSign_place_name() {
        return sign_place_name;
    }

    public void setSign_place_name(String sign_place_name) {
        this.sign_place_name = sign_place_name;
    }

    public boolean is_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }
}
