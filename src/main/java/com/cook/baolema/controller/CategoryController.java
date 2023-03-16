package com.cook.baolema.controller;

import com.cook.baolema.pojo.*;
import com.cook.baolema.service.CategoryService;
import com.cook.baolema.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DishService dishService;
    @GetMapping
    public Result selectAll(){
        List<Category> categories = categoryService.selectAll();
        Integer code = categories != null ? Code.GET_OK : Code.GET_ERR;
        String msg = categories != null ? "" : "数据查询失败，请重试！";
        return new Result(code, categories, msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){

        Category category = categoryService.selectByID(id);
        Integer code = category != null ? Code.GET_OK : Code.GET_ERR;
        String msg = category != null ? "" : "数据查询失败，请重试！";
        return new Result(code, category, msg);
    }
    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = categoryService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");

    }
    @PostMapping
    public Result save(@RequestBody Category category){
        category.setCreatedTime(new Date());
        boolean flag = categoryService.save(category);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }
    @PostMapping("/update")
    public Result update(@RequestBody Category category){
        boolean flag = categoryService.update(category);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");
    }


    /*
    * 返回所有菜品，按类别分类*/
    @GetMapping("/alldishes")
    public Result categoriesAndDishes(){
        List<Category> categories = categoryService.selectAll();
        System.out.println(categories);
        List<CategoryAndDishes> resData = new ArrayList<>();
        for(Category category:categories){
            Integer categoryID = category.getCategoryID();//获取当前类别的id
            String category1 = category.getCategory();//获取当前类别名称
            List<Dish> dishes = dishService.selectByCategoryID(categoryID);//获取当前类别的所有菜品
            CategoryAndDishes categoryAndDishes = new CategoryAndDishes(categoryID, null, category1, dishes);
            resData.add(categoryAndDishes);
        }
        return new Result(Code.GET_OK,resData,null);

    }
}
