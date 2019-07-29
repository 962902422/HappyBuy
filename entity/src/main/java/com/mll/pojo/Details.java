package com.mll.pojo;


public class Details {//商品详情类
    private Integer mp_id;//商品编号
    private String mp_name;//商品名称
    private String mp_descpiption;//商品介绍
    private int mp_price;//商品价格
    private Integer mp_stock;//商品库存
    private Integer mpc_id;//一级菜单编号
    private String mp_file_name;//图片
    private Integer mp_special;//是否为特价商品(1代表是0代表不是)
    private String mp_file_image;//介绍轮播图片
    private String mp_file_special;//型号图片
    private String mp_wheelplanting_image;//详情轮播图片
    private String mp_tpwenzi;//型号文字介绍
    private String mp_image_xiangqing;//商品详情介绍图片
    private String mm_model;//商品型号
    private String mpr_price;//商品价格

    public void setMp_id(Integer mp_id) {
        this.mp_id = mp_id;
    }

    public void setMp_name(String mp_name) {
        this.mp_name = mp_name;
    }

    public void setMp_descpiption(String mp_descpiption) {
        this.mp_descpiption = mp_descpiption;
    }

    public void setMp_price(int mp_price) {
        this.mp_price = mp_price;
    }

    public void setMp_stock(Integer mp_stock) {
        this.mp_stock = mp_stock;
    }

    public void setMpc_id(Integer mpc_id) {
        this.mpc_id = mpc_id;
    }

    public void setMp_file_name(String mp_file_name) {
        this.mp_file_name = mp_file_name;
    }

    public void setMp_special(Integer mp_special) {
        this.mp_special = mp_special;
    }

    public void setMp_file_image(String mp_file_image) {
        this.mp_file_image = mp_file_image;
    }

    public void setMp_file_special(String mp_file_special) {
        this.mp_file_special = mp_file_special;
    }

    public void setMp_wheelplanting_image(String mp_wheelplanting_image) {
        this.mp_wheelplanting_image = mp_wheelplanting_image;
    }

    public void setMp_tpwenzi(String mp_tpwenzi) {
        this.mp_tpwenzi = mp_tpwenzi;
    }

    public void setMp_image_xiangqing(String mp_image_xiangqing) {
        this.mp_image_xiangqing = mp_image_xiangqing;
    }

    public void setMm_model(String mm_model) {
        this.mm_model = mm_model;
    }

    public void setMpr_price(String mpr_price) {
        this.mpr_price = mpr_price;
    }

    public Integer getMp_id() {
        return mp_id;
    }

    public String getMp_name() {
        return mp_name;
    }

    public String getMp_descpiption() {
        return mp_descpiption;
    }

    public int getMp_price() {
        return mp_price;
    }

    public Integer getMp_stock() {
        return mp_stock;
    }

    public Integer getMpc_id() {
        return mpc_id;
    }

    public String getMp_file_name() {
        return mp_file_name;
    }

    public Integer getMp_special() {
        return mp_special;
    }

    public String getMp_file_image() {
        return mp_file_image;
    }

    public String getMp_file_special() {
        return mp_file_special;
    }

    public String getMp_wheelplanting_image() {
        return mp_wheelplanting_image;
    }

    public String getMp_tpwenzi() {
        return mp_tpwenzi;
    }

    public String getMp_image_xiangqing() {
        return mp_image_xiangqing;
    }

    public String getMm_model() {
        return mm_model;
    }

    public String getMpr_price() {
        return mpr_price;
    }
}
