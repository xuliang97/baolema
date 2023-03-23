package com.cook.baolema.controller;

import com.cook.baolema.respdata.Code;
import com.cook.baolema.respdata.HourAndOrderNumber;
import com.cook.baolema.respdata.NumberAndAmount;
import com.cook.baolema.respdata.Result;
import com.cook.baolema.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private OrderInfoService orderInfoService;

    /*
     * 查询今日的所有订单和金额
     * */
    @GetMapping("/today")
    public Result getTodayNumberAndAmount() {
        String[] now = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
        NumberAndAmount numberAndAmount = orderInfoService.selectAmountAndNumberOfToday(now[0], now[1], now[2]);
        if (numberAndAmount == null) {
            return new Result(Code.GET_ERR, null, "请稍后再试");
        }
        return new Result(Code.GET_OK, numberAndAmount, "");
    }

    @GetMapping
    public Result getStatistics() {
        HashMap<String, Object> map = new HashMap<>();
        //日销售额and今日订单
        String[] now = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
        NumberAndAmount numberAndAmount = orderInfoService.selectAmountAndNumberOfToday(now[0], now[1], now[2]);
        map.put("daySales", numberAndAmount);

        //月销售额
        Float MonthTotalAmount = orderInfoService.getMonthTotalAmount();
        map.put("monthSales", MonthTotalAmount);

        //未完成订单
        Integer unpreparedOrders = orderInfoService.getUnpreparedOrders();
        map.put("unfinishedOrders", unpreparedOrders);


        return new Result(Code.GET_OK, map, "");
    }

    @GetMapping("/orderofhour")
    public Result selectOrderOfHour(){
        List<HourAndOrderNumber> hourAndOrderNumbers = orderInfoService.selectOrderOfHour();
        System.out.println(hourAndOrderNumbers.toString());
        ArrayList<Integer> list = new ArrayList<>();
        for(HourAndOrderNumber hourAndOrderNumber:hourAndOrderNumbers){
            list.add(hourAndOrderNumber.getNumberOfOrders());
        }
        return new Result(Code.GET_OK,list,"");
    }
}
