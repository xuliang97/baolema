package com.cook.baolema.controller;

import com.cook.baolema.pojo.Dish;
import com.cook.baolema.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/dishes")
public class DishController {
    @Autowired
    private DishService dishService;
    @GetMapping
    public List<Dish> selectAll(){
        return dishService.selectAll();
    }
    @GetMapping("/{id}")
    public Dish selectByID(@PathVariable Integer id){
        return dishService.selectByID(id);
    }
    @PostMapping
    public String save(@RequestBody Dish dish){
        boolean flag = dishService.save(dish);
        if(flag)
            return "添加菜品成功！";
        else
            return "添加菜品失败！";
    }
    @PutMapping
    public String update(@RequestBody Dish dish){
        boolean flag = dishService.update(dish);
        if(flag)
            return "修改菜品成功！";
        else
            return "修改菜品失败！";
    }
    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable Integer id){
        boolean flag = dishService.deleteByID(id);
        if(flag)
            return "删除成功！";
        else
            return "删除失败！";
    }
}
