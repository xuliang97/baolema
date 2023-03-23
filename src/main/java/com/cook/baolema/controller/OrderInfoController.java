package com.cook.baolema.controller;

import com.cook.baolema.pojo.*;
import com.cook.baolema.respdata.*;
import com.cook.baolema.service.DishService;
import com.cook.baolema.service.OrderDetailService;
import com.cook.baolema.service.OrderInfoService;
import com.cook.baolema.utils.SortList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private RedisTemplate<String, OrderInfo> redisTemplate;

    @PostMapping("add")
    public Result add(OrderInfo orderInfo) {
        redisTemplate.opsForValue().set(String.valueOf(orderInfo.getChefID()), orderInfo);
        Integer code = orderInfo != null ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = orderInfo != null ? "保存成功" : "保存失败";
        return new Result(code, orderInfo, msg);
    }

    @GetMapping("find/{id}")
    public Result find(@PathVariable Integer id) {
        OrderInfo orderInfo = redisTemplate.opsForValue().get(id);
        Integer code = orderInfo != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfo != null ? "" : "数据查询失败，请重试！";
        return new Result(code, orderInfo, msg);
    }

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

//        System.out.println("selectLimitOrders start");

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
        String uuid = UUID.randomUUID().toString().replace("-", "");
        orderInfo.setUuid(uuid);
        boolean flag = orderInfoService.save(orderInfo);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }

    /**
     * 提交订单
     *
     * @param map
     * @return
     */
    @PostMapping("/submit")
    public Result submit(@RequestBody Map<String, Object> map) {
        OrderInfo orderinfo = new OrderInfo();

        Integer customerId = (Integer) map.get("customerID");
        Short status = ((Integer) map.get("status")).shortValue();
        Float totalAmount = Float.parseFloat(String.valueOf(map.get("totalAmount")));

        orderinfo.setCustomerID(customerId);
        orderinfo.setStatus(status);
        orderinfo.setTotalAmount(totalAmount);
        orderinfo.setCreatedTime(new Date());

        //创建uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        orderinfo.setUuid(uuid);
        //System.out.println(uuid);
        boolean flag = orderInfoService.save(orderinfo);
        //System.out.println(flag);

//        //根据customerId查orderId
//        Integer orderId = orderInfoService.checkOrderID(customerId);

        //根据uuid查orderID
        Integer orderId = orderInfoService.checkOrderIDByuuid(uuid);

        ObjectMapper mapper = new ObjectMapper();
        List<OrderDetail> orderDetailList1 = (List<OrderDetail>) map.get("orderDetailList");
        List<OrderDetail> orderDetailList2 = mapper.convertValue(orderDetailList1, new TypeReference<List<OrderDetail>>() {
        });

        for (OrderDetail od : orderDetailList2) {
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setOrderID(orderId);
            orderDetail.setNumber(od.getNumber());
            orderDetail.setDishAmount(od.getDishAmount());
            orderDetail.setDishID(od.getDishID());

            boolean flag1 = orderDetailService.save(orderDetail);
            //System.out.println(flag1);
        }

        HashMap<String, Object> respmap = new HashMap<>();
        respmap.put("orderID", orderId);
        respmap.put("uuid", uuid);

        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, respmap, flag ? "保存成功！" : "保存失败！");
    }

    @PostMapping("/update")
    public Result update(@RequestBody OrderInfo orderInfo) {
        boolean flag = orderInfoService.update(orderInfo);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");

    }

    @PostMapping("/updatestatus")
    public Result updateStatusByOrderID(Integer orderID, Integer status) {
//        System.out.println(status);
        int i = status.intValue();
        boolean flag = orderInfoService.updateStatusByOrderID(orderID, (short) i);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");
    }


    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id) {
        boolean flag = orderInfoService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");
    }

    @GetMapping("/allorder/{pageNum}/{pageSize}") //add resp2
    public Result selectAllByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<RespOrderDetail3> respOrderDetail3PageInfo = orderInfoService.selectAllByPage(pageNum, pageSize);

        Integer code = respOrderDetail3PageInfo != null ? Code.GET_OK : Code.GET_ERR;
        String msg = respOrderDetail3PageInfo != null ? "" : "数据查询失败，请重试！";


        return new Result(code, respOrderDetail3PageInfo, msg);
    }

    @GetMapping("/bycustomerID/{id}")
    public Result selectByCustomerID(@PathVariable Integer id) {
        Integer orderID = orderInfoService.checkOrderID(id);
        Short status = 0;
        List<OrderDetail> orderDetailList = orderDetailService.selectByOrderID(orderID);
        Integer code = orderDetailList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderDetailList != null ? "成功" : "数据查询失败，请重试！";
        List<RespOrderDetail2> respOrderDetail2List = new ArrayList<>();

        for (OrderDetail od : orderDetailList) {
            Integer dishID = od.getDishID();
            Dish dish = dishService.selectByID(dishID);
            String dishName = dish.getDish();
            String description = dish.getDescription();
            String dishPhoto = dish.getDishPhoto();

            RespOrderDetail2 respOrderDetail2 = new RespOrderDetail2();
            respOrderDetail2.setDishName(dishName);
            respOrderDetail2.setDescription(description);
            respOrderDetail2.setDishPhoto(dishPhoto);

            respOrderDetail2.setNumber(od.getNumber());
            respOrderDetail2.setDishAmount(od.getDishAmount());

            respOrderDetail2List.add(respOrderDetail2);
        }

        HashMap<String, Object> respInfo = new HashMap<>();
        respInfo.put("orderID", orderID);
        respInfo.put("status", status);
        respInfo.put("orderDetailList", respOrderDetail2List);

        return new Result(code, respInfo, msg);
    }

    @GetMapping("/orderhistory/{id}")
    public Result selectOrderHistory(@PathVariable Integer id) {
        List<OrderInfo> orderInfos = orderInfoService.selectHistoryOrder(id);
        Integer code = orderInfos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = orderInfos != null ? "成功" : "数据查询失败，请重试！";

        List<OrderInfo> historyOrder = SortList.search(orderInfos);

        return new Result(code, historyOrder, msg);
    }

    @GetMapping("/monthtotalamount")
    public Result getMonthTotalAmount() {
        Float MonthTotalAmount = orderInfoService.getMonthTotalAmount();

        return new Result(Code.GET_OK, MonthTotalAmount, "");
    }

    @GetMapping("/gradenumber")
    public Result selectGradeNumber() {
        List<GradeNumber> gradeNumberList = orderInfoService.selectGradeNumber();
        Integer code = gradeNumberList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = gradeNumberList != null ? "成功" : "数据查询失败，请重试！";
        return new Result(code, gradeNumberList, msg);
    }

    @GetMapping("/orderdetail/{id}")
    public Result getOrderAndDetail(@PathVariable Integer id) {
        OrderInfo orderInfo = orderInfoService.selectByID(id);

        List<RespOrderDetail2> respOrderDetail2s = dishService.selectDishAndOrderDetail(id);
        RespOrderInfo2 respOrderInfo2 = new RespOrderInfo2();

        respOrderInfo2.setOrderId(id);
        respOrderInfo2.setStatus(orderInfo.getStatus());
        respOrderInfo2.setUuid(orderInfo.getUuid());
        respOrderInfo2.setCreatedTime(orderInfo.getCreatedTime());
        respOrderInfo2.setTotalAmount(orderInfo.getTotalAmount());
        respOrderInfo2.setOrderDetailList2(respOrderDetail2s);
        return new Result(Code.GET_OK, respOrderInfo2, "");
    }


}
