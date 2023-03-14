package com.cook.baolema.controller;

import com.cook.baolema.pojo.Code;
import com.cook.baolema.pojo.Dish;
import com.cook.baolema.pojo.OrderInfo;
import com.cook.baolema.pojo.Result;
import com.cook.baolema.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orderinfo")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @GetMapping
    public Result selectAll(){
        List<OrderInfo> orderInfos = orderInfoService.selectAll();
        Integer code = orderInfos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfos != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderInfos, msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){
        OrderInfo orderInfo = orderInfoService.selectByID(id);
        Integer code = orderInfo != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfo != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderInfo, msg);
    }
    @PostMapping
    public Result save(@RequestBody OrderInfo orderInfo){
        orderInfo.setCreatedTime(new Date());
        boolean flag = orderInfoService.save(orderInfo);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }
    @PostMapping("/update")
    public Result update(@RequestBody OrderInfo orderInfo){
        boolean flag = orderInfoService.update(orderInfo);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");

    }
    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = orderInfoService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");

    }
}
