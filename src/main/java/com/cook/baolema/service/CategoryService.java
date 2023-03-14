package com.cook.baolema.service;

import com.cook.baolema.pojo.Category;


import java.util.List;

/**
 * @author 徐亮
 */
public interface CategoryService{
    public List<Category> selectAll();
    public Category selectByID(Integer id);
    public boolean deleteByID(Integer id);
    public boolean update(Category category);
    public boolean save(Category category);


}
