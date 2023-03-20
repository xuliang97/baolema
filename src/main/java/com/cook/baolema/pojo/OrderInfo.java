package com.cook.baolema.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderInfo implements Serializable, Comparable<OrderInfo> {
    private Integer orderID;
    private Integer customerID;
    private Integer chefID;
    private Short status;
    private String userRatings;
    private Float totalAmount;
    private Date createdTime;

    @Override
    public int compareTo(OrderInfo o) {
        return 0;
    }
}
