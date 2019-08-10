package com.mll.mapper;

import com.mll.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    @Select("SELECT * FROM `MLL`.`MLL_ORDER`")
    List<Order> sel();

    @Select("SELECT * FROM `MLL`.`MLL_ORDER` WHERE mo_type=#{id}")
    List<Order> selById(int id);

    //发货
    @Update("")
    int shipping(int oid);

    @Update("UPDATE `MLL`.`MLL_ORDER` SET `mo_user_name` = #{name} " +
            " WHERE `mo_id`=#{oid} ;")
    int updName(@Param("oid") int oid,@Param("name") String name);

    @Update("UPDATE `MLL`.`MLL_ORDER` SET `mo_user_address` = #{address} " +
            " WHERE `mo_id`=#{oid} ;")
    int updAddress(@Param("oid") int oid,@Param("name")String address);

    @Update("UPDATE `MLL`.`MLL_ORDER` SET `mo_shouji` = #{phone} " +
            " WHERE `mo_id`=#{oid} ;")
    int updPhone(@Param("oid") int oid,@Param("name")String phone);
}
