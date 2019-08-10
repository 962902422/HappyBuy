package com.mll.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class MLL_Order {
    /*`mo_id`,
            `mu_user_id`,
            `mo_user_name`,
            `mo_user_address`,
            `mo_create_time`,
            `mo_cost`,
            `mo_mobile`,
            `mo_status`,
            `mo_type`,
            `mo_isdel`*/
    private int mo_id;
    private int mu_user_id;
    private String mo_user_name;
    private String mo_user_address;
    private Date mo_create_time;
    private double mo_cost;
    private String mo_mobile;
    private int mo_status;
    private int mo_type;
    private int mo_isdel;
}
