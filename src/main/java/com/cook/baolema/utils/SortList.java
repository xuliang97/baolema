package com.cook.baolema.utils;

import com.cook.baolema.pojo.OrderInfo;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SortList {
    public static List<OrderInfo> search(List<OrderInfo> orderInfos){
        Collections.sort(orderInfos, new Comparator<OrderInfo>() {
            @Override
            public int compare(OrderInfo o1, OrderInfo o2) {
                Date date1 = o1.getCreatedTime();
                Date date2 = o2.getCreatedTime();
                int compareTo = date2.compareTo(date1);
                return compareTo;
            }
        });
        return orderInfos;
    }
}
