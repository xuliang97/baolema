package com.cook.baolema.controller;

import com.cook.baolema.pojo.Category;
import com.cook.baolema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<Category> selectAll(){
        return categoryService.selectAll();
    }
    @GetMapping("/{id}")
    public Category selectByID(@PathVariable Integer id){
        return categoryService.selectByID(id);
    }
    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable Integer id){
        boolean flag = categoryService.deleteByID(id);
        if(flag)
            return "删除成功！";
        else
            return "删除失败！";
    }
    @PostMapping
    public String save(@RequestBody Category category){
        boolean flag = categoryService.save(category);
        if(flag)
            return "新增类别成功！";
        else
            return "新增类别失败！";
    }
    @PutMapping
    public String update(@RequestBody Category category){
        boolean flag = categoryService.update(category);
        if(flag)
            return "修改成功！";
        else
            return "修改失败！";
    }


}
