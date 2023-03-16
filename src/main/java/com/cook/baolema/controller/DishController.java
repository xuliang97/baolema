package com.cook.baolema.controller;

import com.cook.baolema.pojo.Code;
import com.cook.baolema.pojo.Dish;
import com.cook.baolema.pojo.Result;
import com.cook.baolema.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Result selectAll(){

        List<Dish> dishes = dishService.selectAll();
        Integer code = dishes != null ? Code.GET_OK : Code.GET_ERR;
        String msg = dishes != null ? "" : "数据查询失败，请重试！";
        return new Result(code, dishes, msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){
        Dish dish = dishService.selectByID(id);
        Integer code = dish != null ? Code.GET_OK : Code.GET_ERR;
        String msg = dish != null ? "" : "数据查询失败，请重试！";
        return new Result(code, dish, msg);
    }
    @PostMapping
    public Result save(@RequestBody Dish dish){
        System.out.println(dish);
        dish.setCreatedTime(new Date());
        if(dish.getDishPhoto() == null){
            dish.setDishPhoto("static/dish.jpg");
        }
        boolean flag = dishService.save(dish);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }
    @PostMapping("/update")
    public Result update(@RequestBody Dish dish){
        boolean flag = dishService.update(dish);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");

    }
    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = dishService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");

    }
    @GetMapping("/bycategory/{categoryID}")
     public Result selectByCategoryID(@PathVariable Integer categoryID){
        List<Dish> dishes = dishService.selectByCategoryID(categoryID);
        Integer code = dishes != null ? Code.GET_OK : Code.GET_ERR;
        String msg = dishes != null ? "" : "数据查询失败，请重试！";
        return new Result(code, dishes, msg);
    }
    @GetMapping("/byname/{name}")
    public Result selectByName(@PathVariable String name){
        Dish dish = dishService.selectByName(name);
        Integer code = dish != null ? Code.GET_OK : Code.GET_ERR;
        String msg = dish != null ? "" : "数据查询失败，请重试！";
        return new Result(code,dish,msg);
    }

}
