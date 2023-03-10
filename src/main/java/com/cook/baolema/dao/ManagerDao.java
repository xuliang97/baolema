package com.cook.baolema.dao;

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
}
