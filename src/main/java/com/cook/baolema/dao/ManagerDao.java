package com.cook.baolema.dao;

import com.cook.baolema.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    @Select("select * from tb_manager where id=#{id}")
    Manager selectByID(Integer id);
}
