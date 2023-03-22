package com.cook.baolema.service.imps;

import com.cook.baolema.dao.DishDao;
import com.cook.baolema.pojo.Dish;
import com.cook.baolema.respdata.DishNumber;
import com.cook.baolema.respdata.RespOrderDetail2;
import com.cook.baolema.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐亮
 */
@Service
public class DishServiceImp implements DishService {
    @Autowired
    private DishDao dishDao;
    @Override
    public List<Dish> selectAll() {
        return dishDao.selectAll();
    }

    @Override
    public Dish selectByID(Integer id) {
        return dishDao.selectByID(id);
    }

    @Override
    public boolean deleteByID(Integer id) {
        return dishDao.deleteByID(id)>0;
    }

    @Override
    public boolean update(Dish dish) {
        return dishDao.update(dish)>0;
    }

    @Override
    public boolean save(Dish dish) {
        return dishDao.save(dish)>0;
    }

    @Override
    public List<Dish> selectByCategoryID(Integer categoryID) {
        return dishDao.selectByCategoryID(categoryID);
    }

    @Override
    public Dish selectByName(String name) {
        return dishDao.selectByName(name);
    }

    @Override
    public List<DishNumber> selectDishNumber() {
        return dishDao.selectDishNumber();
    }

    @Override
    public List<RespOrderDetail2> selectDishAndOrderDetail(Integer id) {
        return dishDao.selectDishAndOrderDetail(id);
    }


}
