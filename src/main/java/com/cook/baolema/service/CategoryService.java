package com.cook.baolema.service;

import com.cook.baolema.pojo.Category;
import com.cook.baolema.pojo.Dish;

import java.util.List;

/**
 * @author 徐亮
 */
public interface CategoryService{
    public List<Category> selectAll();
    public Category selectByID(Integer id);
    public boolean deleteByID(Integer id);
    public boolean update(Dish dish);
    public boolean save(Dish dish);
}
