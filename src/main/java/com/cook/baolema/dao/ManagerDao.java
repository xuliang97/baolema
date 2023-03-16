package com.cook.baolema.dao;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlManageInstanceGroupStatement;
import com.cook.baolema.pojo.Manager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 徐亮
 */
@Mapper
public interface ManagerDao {
    /*
    查询所有管理员
    * */
    @Select("select * from tb_manager")
    List<Manager> selectAll();

    /*
    按id查询管理员
    * */
    @Select("select * from tb_manager where managerID=#{id}")
    Manager selectByID(Integer id);

    /*
    增加or保存管理员
    * */
    @Insert("insert into tb_manager values (null,#{manager},#{gender},#{profilePhoto},#{phoneNumber},#{password},#{createdTime})")
    int save(Manager newManager);


    @Update("update tb_manager set manager=#{manager},gender=#{gender},profilePhoto=#{profilePhoto},phoneNumber=#{phoneNumber},password=#{password},createdTime=#{createdTime} where managerID=#{managerID}")
    int update(Manager newManager);


    @Delete("delete from tb_manager where managerID=#{id}")
    int deleteByID(Integer id);

    /*
    * 按手机号查询数据
    * */
    @Select("select * from tb_manager where phoneNumber=#{phoneNumber}")
    Manager selectByPhoneNumber(String phoneNumber);

    /*
    * 根据手机号密码查询*/
    @Select("select * from tb_manager where phoneNumber=#{phoneNumber} and password=#{password}")
    Manager selectByPhoneAndPwd(@Param("phoneNumber")String phoneNumber,@Param("password")String password);

    @Update("update tb_manager set password=#{password} where managerID=#{managerID}")
    int updatePwd(String password,Integer managerID);
}
