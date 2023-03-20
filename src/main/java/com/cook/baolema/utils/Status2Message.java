package com.cook.baolema.utils;

public class Status2Message {
    public static String change(Short status){
        if(status == 0){
            return "订单确认";
        }else if(status == 1){
            return "备餐";
        }else if(status == 2){
            return "已出餐";
        }else
            return "订单完成";
    }
}
