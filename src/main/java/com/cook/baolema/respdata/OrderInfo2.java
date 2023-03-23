package com.cook.baolema.respdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo2 {
    private Integer orderID;
    private Integer customerID;
    private Integer chefID;
    private Short status;
    private String statusMessage;
    private String comment;
    private Float totalAmount;
    private Date createdTime;
    private String phoneNumber;
}
