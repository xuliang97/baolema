package com.cook.baolema.controller;

import com.cook.baolema.respdata.Code;
import com.cook.baolema.respdata.NumberAndAmount;
import com.cook.baolema.respdata.Result;
import com.cook.baolema.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/statistics")
public class AmountController {

    @Autowired
    private OrderInfoService orderInfoService;
    /*
     * 查询今日的所有订单和金额
     * */
    @GetMapping("/today")
    public Result getTodayNumberAndAmount(){
        String[] now = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
        NumberAndAmount numberAndAmount = orderInfoService.selectAmountAndNumberOfToday(now[0], now[1], now[2]);
        if(numberAndAmount == null){
            return new Result(Code.GET_ERR,null,"请稍后再试");
        }
        return new Result(Code.GET_OK,numberAndAmount,"");
    }


}
