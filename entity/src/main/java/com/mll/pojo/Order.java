package com.mll.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@ToString
@Getter
public class Order {//订单详情表

    private int mo_id;//订单编号
    private int mu_user_id;//用户编号
    private String mo_user_name;//收货人姓名
    private String mo_user_address;//收货人详细地址
    private Date mo_create_time;//下单时间
    private int mo_uuid;//订单号
    private String mo_sum;//订单总金额
    private int mo_type;//订单状态
    private int mo_fangshi;//支付方式
    private String mo_shouji;//联系方式(手机号码)


    public void setMo_shouji(String mo_shouji) {
        this.mo_shouji = mo_shouji;
    }

    public String getMo_shouji() {
        return mo_shouji;
    }

    public int getMo_id() {
        return mo_id;
    }

    public int getMu_user_id() {
        return mu_user_id;
    }

    public String getMo_user_name() {
        return mo_user_name;
    }

    public String getMo_user_address() {
        return mo_user_address;
    }

    public Date getMo_create_time() {
        return mo_create_time;
    }

    public int getMo_uuid() {
        return mo_uuid;
    }

    public String getMo_sum() {
        return mo_sum;
    }

    public int getMo_type() {
        return mo_type;
    }

    public int getMo_fangshi() {
        return mo_fangshi;
    }

    public void setMo_id(int mo_id) {
        this.mo_id = mo_id;
    }

    public void setMu_user_id(int mu_user_id) {
        this.mu_user_id = mu_user_id;
    }

    public void setMo_user_name(String mo_user_name) {
        this.mo_user_name = mo_user_name;
    }

    public void setMo_user_address(String mo_user_address) {
        this.mo_user_address = mo_user_address;
    }

    public void setMo_create_time(Date mo_create_time) {
        this.mo_create_time = mo_create_time;
    }

    public void setMo_uuid(int mo_uuid) {
        this.mo_uuid = mo_uuid;
    }

    public void setMo_sum(String mo_sum) {
        this.mo_sum = mo_sum;
    }

    public void setMo_type(int mo_type) {
        this.mo_type = mo_type;
    }

    public void setMo_fangshi(int mo_fangshi) {
        this.mo_fangshi = mo_fangshi;
    }
}
