package com.mll.mapper;

import com.mll.pojo.MLL_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM `MLL`.`MLL_USERS` " +
            "WHERE mu_user_name='{username}' AND mu_password='{password}'")
    MLL_User login(@Param("username") String username, @Param("password") String password);

    @Select("SELECT mu.`mu_user_id`, " +
            "            `mu_user_name`, mu_headphoto," +
            "            mu_mobile," +
            "            `mu_password`, " +
            "            `mu_registerTime`, " +
            "            `mu_email`,`mr_name`,`mr_mobile`,`mr_address`,`mr_detail_address`,`mr_postal_code`,mr_default FROM `MLL`.`MLL_USERS` mu " +
            "            LEFT JOIN MLL_RECEIVING mr ON mr.mu_user_id=mu.mu_user_id " +
            "            WHERE  mr.mr_default=1 OR mr_default IS NULL " +
            "            GROUP BY mu.mu_user_id  " +
            "            HAVING mu_user_name='admin' ")
    MLL_User userinfo();

    @Select("SELECT mu.`mu_user_id`, \n" +
            "\t`mu_user_name`, \n" +
            "\t`mu_password`, \n" +
            "\t`mu_registerTime`, \n" +
            "\t`mu_email`,`mr_name`,`mr_mobile`,`mr_address`,`mr_detail_address`,`mr_postal_code`,mr_default FROM `MLL`.`MLL_USERS` mu\n" +
            "LEFT JOIN MLL_RECEIVING mr ON mr.mu_user_id=mu.mu_user_id\n" +
            "WHERE mr.mr_default=1 OR mr_default IS NULL\n" +
            "GROUP BY mu.mu_user_id ")
    List<MLL_User> selAllUser();

    @Update("UPDATE `MLL`.`MLL_USERS` SET `mu_email`=#{email} " +
            " WHERE `mu_user_id`=#{id} ;")
    int updEmail(@Param("id") int uid,@Param("email") String email);

    @Update("UPDATE `MLL`.`MLL_RECEIVING` SET `mr_mobile`=#{mobile} " +
            " WHERE mu_user_id =#{id} AND mr_default=1;")
    int updMobile(@Param("id") int uid,@Param("mobile") String mobile);

    @Update("")
    int updAddress(int uid,String address);

    @Update("UPDATE `MLL`.`MLL_RECEIVING` SET `mr_name`=#{name} " +
            " WHERE mu_user_id =#{id} AND mr_default=1;")
    int updName(@Param("id") int uid,@Param("name") String name);

    @Update("UPDATE `MLL`.`MLL_RECEIVING` SET `mr_postal_code`=#{code} " +
            " WHERE mu_user_id =#{id} AND mr_default=1;")
    int updCode(@Param("id") int uid,@Param("code") int code);

    @Update("UPDATE `MLL`.`MLL_USERS` SET `mu_password`=#{password},`mu_email`=#{email},`mu_mobile`=#{mobile} " +
            " WHERE `mu_user_id`=1;")
    int updUser(@Param("password") String password,@Param("email") String email,@Param("mobile") String mobile);

    @Update("UPDATE `MLL`.`MLL_RECEIVING` SET `mr_name`=#{name},`mr_address`=#{address},`mr_detail_address`=#{addressInfo},`mr_postal_code`=#{code} " +
            " WHERE mu_user_id=1 AND mr_default=1;")
    int updUserInfo(@Param("name") String name,@Param("address") String address,@Param("addressInfo") String addressInfo,@Param("code") String code);

    @Update("UPDATE `MLL`.`MLL_USERS` SET `mu_headphoto`= #{name}" +
            " WHERE `mu_user_id`=1;")
    int updHerdImage(String name);
}
