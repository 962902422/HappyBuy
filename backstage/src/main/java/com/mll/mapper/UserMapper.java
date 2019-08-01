package com.mll.mapper;

import com.mll.pojo.MLL_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM `MLL`.`MLL_USERS` " +
            "WHERE mu_user_name='{username}' AND mu_password='{password}'")

    MLL_User login(@Param("username") String username, @Param("password") String password);

    @Select("SELECT mu_password FROM `MLL`.`MLL_USERS` " +
            "WHERE mu_user_name='admin' ")
    String password();

    @Select("SELECT  `mu_user_id`,`mu_user_name`,`mu_password`,`mu_headphoto`,`mu_registerTime`,`mu_email`,`mu_mobile`,`mu_status` " +
            " FROM `MLL`.`MLL_USERS` ")
    List<MLL_User> selAllUser();
}
