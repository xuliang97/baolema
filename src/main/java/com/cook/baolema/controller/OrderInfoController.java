package com.cook.baolema.controller;

import com.cook.baolema.pojo.*;
import com.cook.baolema.service.DishService;
import com.cook.baolema.service.OrderDetailService;
import com.cook.baolema.service.OrderInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orderinfo")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private DishService dishService;

    @GetMapping
    public Result selectAll() {
        List<OrderInfo> orderInfos = orderInfoService.selectAll();
        Integer code = orderInfos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfos != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderInfos, msg);
    }

    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id) {
        OrderInfo orderInfo = orderInfoService.selectByID(id);
        Integer code = orderInfo != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfo != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderInfo, msg);
    }

    @GetMapping("/{status}/{limit}")
    public Result selectLimitOrders(@PathVariable short status, @PathVariable Integer limit) {

        System.out.println("selectLimitOrders start");

        List<RespOrderInfo> respOrderInfoList = new ArrayList<>();

        //根据status和limit获得订单表
        List<OrderInfo> orderInfos = orderInfoService.selectLimit(status, limit);

        for (OrderInfo info : orderInfos) {
            RespOrderInfo respOrderInfo = new RespOrderInfo();
            //复制订单状态
            respOrderInfo.setOrderId(info.getOrderID());
            respOrderInfo.setStatus(info.getStatus());

            //根据orderid生成订单详情的list
            List<OrderDetail> orderDetails = orderDetailService.selectByOrderID(info.getOrderID());
            List<RespOrderDetail> respOrderDetailList = new ArrayList<>();
            //计算每个订单的金额
            Float sum = 0.0f;
            for (OrderDetail od : orderDetails) {
                Dish dish = dishService.selectByID(od.getDishID());
                RespOrderDetail respOrderDetail = new RespOrderDetail();
                respOrderDetail.setDishName(dish.getDish());
                respOrderDetail.setDishAmount(od.getNumber() * dish.getPrice());
                respOrderDetail.setNumber(od.getNumber());

                sum += respOrderDetail.getDishAmount();

                respOrderDetailList.add(respOrderDetail);
            }

            respOrderInfo.setOrderDetailList(respOrderDetailList);
            respOrderInfoList.add(respOrderInfo);
        }

        Integer code = orderInfos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfos != null ? "" : "数据查询失败，请重试！";

        return new Result(code, respOrderInfoList, msg);
    }

    @PostMapping
    public Result save(@RequestBody OrderInfo orderInfo) {
        orderInfo.setCreatedTime(new Date());
        boolean flag = orderInfoService.save(orderInfo);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }

    @PostMapping("/update")
    public Result update(@RequestBody OrderInfo orderInfo) {
        boolean flag = orderInfoService.update(orderInfo);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");

    }

    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id) {
        boolean flag = orderInfoService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");
    }
    @GetMapping("/pages")
    public Result selectAllByPage(Integer pageNum,Integer pageSize){
        PageInfo<OrderInfo> orderInfos = orderInfoService.selectAllByPage(pageNum,pageSize);
        Integer code = orderInfos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfos != null ? "" : "数据查询失败，请重试！";
        return new Result(code,orderInfos,msg);
    }


}
