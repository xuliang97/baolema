package com.cook.baolema.controller;

import com.cook.baolema.pojo.Manager;
import com.cook.baolema.service.ManagerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @GetMapping
    public List<Manager> selectAll(){
        return managerService.selectAll();
    }
    @GetMapping("/{id}")
    public Manager selectByID(@PathVariable("id") Integer id){
        return managerService.selectByID(id);
    }

    @PostMapping
    public String save(@RequestBody Manager manager){
        boolean flag = managerService.save(manager);
        if(flag){
            return "添加管理员成功！";
        }else{
            return "添加管理员失败！";
        }
    }

    @PutMapping
    public String update(@RequestBody Manager manager){
        boolean flag = managerService.update(manager);
        if(flag){
            return "修改成功！";
        }else{
            return "修改失败！";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable Integer id){
        boolean flag = managerService.deleteByID(id);
        if(flag){
            return "删除成功！";
        }else{
            return "删除失败！";
        }
    }
}
