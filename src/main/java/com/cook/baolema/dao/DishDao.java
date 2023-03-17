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
    @Select("select * from tb_dish where deleted=0")
    List<Dish> selectAll();

    /*
    按id查询菜品
     */
    @Select("select * from tb_dish where dishID=#{id} and deleted=0")
    Dish selectByID(Integer id);

    /*
    增加or保存菜品
    * */
    @Insert("insert into tb_dish(`dish`, `categoryID`, `dishPhoto`, `description`, `price`, `inventory`, `createdTime`) values (#{dish},#{categoryID},#{dishPhoto},#{description},#{price},#{inventory},#{createdTime})")
    int save(Dish newDish);

    /*
    * 修改菜品信息
    * */
    @Update("update tb_dish set dish=#{dish},categoryID=#{categoryID},dishPhoto=#{dishPhoto},description=#{description},price=#{price},inventory=#{inventory} where dishID=#{dishID}")
    int update(Dish newDish);

    /*
    * 删除菜品
    * */
    @Update("update tb_dish set deleted=1 where dishID=#{id}")
    int deleteByID(Integer id);

    /*
    * 根据类别查询菜品
    * */
    @Select("select * from tb_dish where categoryID=#{categoryID} and deleted=0")
    List<Dish> selectByCategoryID(Integer categoryID);

    /**
     * 根据菜品名称查询菜品
     * @param name
     * @return
     */
    @Select("select * from tb_dish where dish=#{dish} and deleted=0")
    Dish selectByName(String name);
}
