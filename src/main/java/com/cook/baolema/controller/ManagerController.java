package com.cook.baolema.controller;

import com.cook.baolema.pojo.Code;
import com.cook.baolema.pojo.Manager;
import com.cook.baolema.pojo.Result;
import com.cook.baolema.service.ManagerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Result selectAll(){
        List<Manager> managers = managerService.selectAll();
        Integer code = managers != null ? Code.GET_OK : Code.GET_ERR;
        String msg = managers != null ? "" : "数据查询失败，请重试！";
        return new Result(code, managers, msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable("id") Integer id){

        Manager manager = managerService.selectByID(id);
        Integer code = manager != null ? Code.GET_OK : Code.GET_ERR;
        String msg = manager != null ? "" : "数据查询失败，请重试！";
        return new Result(code, manager, msg);
    }

    @PostMapping
    public Result save(@RequestBody Manager manager){
        if(manager.getProfilePhoto() == null){
            manager.setProfilePhoto("static/customer.jpg");
        }
        manager.setCreatedTime(new Date());
        boolean flag = managerService.save(manager);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }

    @PostMapping("/update")
    public Result update(@RequestBody Manager manager){
        boolean flag = managerService.update(manager);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");

    }

    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = managerService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");

    }
}
