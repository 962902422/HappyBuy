package com.mll.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class MLL_User implements Serializable {
    private Integer mu_user_id;
    private  String mu_user_name;
    private  String mu_password;
    private String mu_headphoto;
    private Date mu_registerTime;
    private String mu_email;
    private String mu_mobile;
    private String mu_status;
    private String mr_name;
    private String mr_mobile;
    private String mr_address;
    private String mr_detail_address;
    private String mr_postal_code;
}
