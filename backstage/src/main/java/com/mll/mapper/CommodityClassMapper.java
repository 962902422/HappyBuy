package com.mll.mapper;

import com.mll.pojo.MLL_PRODUCT_CATEGORY;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityClassMapper {

    @Select("SELECT * FROM MLL_PRODUCT_CATEGORY")
    List<MLL_PRODUCT_CATEGORY> sel();

    @Select("SELECT COUNT(1) FROM MLL_PRODUCT_CATEGORY " +
            " WHERE parent_id=#{id}")
    Integer count(int id);

    @Delete("DELETE FROM `MLL`.`MLL_PRODUCT_CATEGORY` " +
            " WHERE `mpc_id`=#{id}")
    Integer del(int id);

    @Delete("UPDATE `MLL`.`MLL_PRODUCT_CATEGORY` SET `mpc_name` =#{name} " +
            " WHERE `mpc_id`=#{id} ")
    Integer upd(@Param("id") int id,@Param("name") String name);

    @Select("SELECT * FROM `MLL`.`MLL_PRODUCT_CATEGORY` WHERE parent_id=0")
    List<MLL_PRODUCT_CATEGORY> selByid();


    @Select("SELECT `mpc_id`,`mpc_name`,`parent_id` " +
            "   FROM `MLL`.`MLL_PRODUCT_CATEGORY` " +
            "   WHERE parent_id=#{pid}")
    List<MLL_PRODUCT_CATEGORY> selBypid(int pid);

    @Insert("INSERT INTO `MLL`.`MLL_PRODUCT_CATEGORY` (`mpc_name`,`parent_id`) " +
            "VALUES (#{name},#{pid});")
    int add(@Param("pid") int pid,@Param("name") String name);

    @Select("SELECT \t`mpc_id`,`mpc_name`,`parent_id` " +
            " FROM `MLL`.`MLL_PRODUCT_CATEGORY` " +
            " WHERE parent_id=0")
    List<MLL_PRODUCT_CATEGORY> selOneClass();
}
