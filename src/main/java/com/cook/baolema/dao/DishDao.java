package com.cook.baolema.dao;

import com.cook.baolema.pojo.Dish;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 徐亮
 */
@Mapper
public interface DishDao {
    /*
    查询所有菜品
    * */
    @Select("select * from tb_dish")
    List<Dish> selectAll();

    /*
    按id查询菜品
     */
    @Select("select * from tb_dish where dishID=#{id}")
    Dish selectByID(Integer id);

    /*
    增加or保存菜品
    * */
    @Insert("insert into tb_dish values (null,#{dish},#{categoryID},#{dishPhoto},#{description},#{price},#{Inventory},#{createdTime})")
    int save(Dish dish);

    /*
    * 修改菜品信息
    * */
    @Update("update tb_dish set dish=#{dish},categoryID=#{categoryID},dishPhoto=#{dishPhoto},description=#{description},price=#{price},Inventory=#{Inventory} where dishID=#{dishID}")
    int update(Dish dish);

    /*
    * 删除菜品
    * */
    @Delete("delete from tb_dish where dishID=#{id}")
    int deleteByID(Integer id);
}
