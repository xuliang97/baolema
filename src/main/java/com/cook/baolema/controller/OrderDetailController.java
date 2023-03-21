package com.cook.baolema.controller;

import com.cook.baolema.pojo.Code;
import com.cook.baolema.pojo.OrderDetail;
import com.cook.baolema.pojo.Result;
import com.cook.baolema.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    @GetMapping
    public Result selectAll(){
        List<OrderDetail> orderDetails = orderDetailService.selectAll();
        Integer code = orderDetails != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderDetails != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderDetails, msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){
        OrderDetail orderDetail = orderDetailService.selectByID(id);
        Integer code = orderDetail != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderDetail != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderDetail, msg);
    }
    @PostMapping
    public Result save(@RequestBody OrderDetail orderDetail){
        boolean flag = orderDetailService.save(orderDetail);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");
    }
    @PostMapping("/update")
    public Result update(@RequestBody OrderDetail orderDetail){
        boolean flag = orderDetailService.update(orderDetail);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");

    }
    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = orderDetailService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");

    }
    @GetMapping("/byorder/{orderID}")
    public Result selectByOrderID(@PathVariable Integer orderID){
        List<OrderDetail> orderDetails = orderDetailService.selectByOrderID(orderID);
        Integer code = orderDetails != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderDetails != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderDetails, msg);
    }
}
