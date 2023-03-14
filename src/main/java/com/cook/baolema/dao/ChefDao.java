package com.cook.baolema.dao;

import com.cook.baolema.pojo.Chef;
import com.cook.baolema.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChefDao {

    @Select("select * from tb_chef")
    List<Chef> selectAll();

    @Select("select * from tb_chef where chefID=#{id}")
    Chef selectByID(Integer id);

    @Insert("insert into tb_chef values (null,#{chef},#{gender},#{profilePhoto},#{phoneNumber},#{password},#{createdTime},#{performance})")
    int save(Chef newChef);

    @Update("update tb_chef set chef=#{chef},gender=#{gender},profilePhoto=#{profilePhoto},phoneNumer=#{phoneNumber},password=#{password},createdTime=#{createdTime},performance=#{performance} where chefID=#{chefID}")
    int update(Chef newChef);

    @Delete("delete from tb_chef where chefID=#{id}")
    int deleteByID(Integer id);

    @Select("select * from tb_chef where phoneNumber=#{phoneNumber} and password=#{password}")
    Chef selectByPhoneAndPwd(@Param("phoneNumber")String phoneNumber, @Param("password")String password);
}
