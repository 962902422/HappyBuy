package com.mll.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
public class Order_Detail {//订单中商品信息

    private int mod_id;//订单详情id
    private String mo_name;//商品名称
    private String mp_xinghao;//商品型号
    private int mod_count;//商品数量
    private int mod_xiaoji;//商品小计
    private int mod_oid;

    public int getMod_id() {
        return mod_id;
    }

    public String getMo_name() {
        return mo_name;
    }

    public String getMp_xinghao() {
        return mp_xinghao;
    }


    public int getMod_count() {
        return mod_count;
    }

    public int getMod_xiaoji() {
        return mod_xiaoji;
    }

    public void setMod_id(int mod_id) {
        this.mod_id = mod_id;
    }

    public void setMo_name(String mo_name) {
        this.mo_name = mo_name;
    }

    public void setMp_xinghao(String mp_xinghao) {
        this.mp_xinghao = mp_xinghao;
    }

    public void setMod_count(int mod_count) {
        this.mod_count = mod_count;
    }

    public void setMod_xiaoji(int mod_xiaoji) {
        this.mod_xiaoji = mod_xiaoji;
    }
}
