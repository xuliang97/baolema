package com.cook.baolema.service.imps;

import com.cook.baolema.dao.CategoryDao;
import com.cook.baolema.pojo.Category;
import com.cook.baolema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐亮
 */
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }

    @Override
    public Category selectByID(Integer id) {
        return categoryDao.selectByID(id);
    }

    @Override
    public boolean deleteByID(Integer id) {
        return categoryDao.deleteByID(id)>0;
    }

    @Override
    public boolean update(Category category) {
        return categoryDao.update(category)>0;
    }

    @Override
    public boolean save(Category category) {
        return categoryDao.save(category)>0;
    }
}
