package com.cook.baolema.service;

import com.cook.baolema.pojo.Dish;
import com.cook.baolema.respdata.DishNumber;
import com.cook.baolema.respdata.RespOrderDetail2;

import java.util.List;

/**
 * @author 徐亮
 */
public interface DishService {
    List<Dish> selectAll();

    List<Dish> selectAllWithout1();

    Dish selectByID(Integer id);

    boolean deleteByID(Integer id);

    boolean update(Dish dish);

    boolean save(Dish dish);

    List<Dish> selectByCategoryID(Integer categoryID);

    Dish selectByName(String name);

    List<DishNumber> selectDishNumber();

    List<RespOrderDetail2> selectDishAndOrderDetail(Integer id);

}
