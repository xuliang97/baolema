package com.cook.baolema.respdata;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")

    private Date createdTime;
    private String phoneNumber;
}
