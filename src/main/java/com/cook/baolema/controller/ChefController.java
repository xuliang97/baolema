package com.cook.baolema.controller;

import com.cook.baolema.pojo.Chef;
import com.cook.baolema.respdata.Code;
import com.cook.baolema.respdata.Result;
import com.cook.baolema.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chef")
public class ChefController {
    @Autowired
    private ChefService chefService;

    @Resource
    private RedisTemplate<String, Chef> redisTemplate;

    @PostMapping("add")
    public Result add(Chef chef){
        redisTemplate.opsForValue().set(String.valueOf(chef.getChefID()),chef);
        Integer code = chef != null ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = chef != null ? "保存成功" : "保存失败";
        return new Result (code,chef,msg);
    }

    @GetMapping("find/{id}")
    public Result find(@PathVariable Integer id){
        Chef chef = redisTemplate.opsForValue().get(id);
        Integer code = chef != null ? Code.GET_OK : Code.GET_ERR;
        String msg = chef != null ? "" : "数据查询失败，请重试！";
        return new Result(code,chef,msg);
    }

    @GetMapping
    public Result selectAll(){
        List<Chef> chefs = chefService.selectAll();
        Integer code = chefs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = chefs != null ? "" : "数据查询失败，请重试！";
        return new Result(code,chefs,msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){
        Chef chef = chefService.selectByID(id);
        Integer code = chef != null ? Code.GET_OK : Code.GET_ERR;
        String msg = chef != null ? "" : "数据查询失败，请重试！";
        return new Result(code,chef,msg);
    }
    @PostMapping
    public Result save(@RequestBody Chef chef){
        chef.setCreatedTime(new Date());
        if(chef.getProfilePhoto() == null){
            chef.setProfilePhoto("static/chef.jpg");
        }
        boolean flag = chefService.save(chef);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");
    }
    @PostMapping("/update")
    public Result update(@RequestBody Chef chef){
        boolean flag = chefService.update(chef);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");
    }
    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = chefService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");
    }
}
