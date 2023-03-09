package com.cook.baolema.service;

import com.cook.baolema.pojo.Dish;

import java.util.List;

/**
 * @author 徐亮
 */
public interface DishService {
    public List<Dish> selectAll();
    public Dish selectByID(Integer id);
    public boolean deleteByID(Integer id);
    public boolean update(Dish dish);
    public boolean save(Dish dish);
}
