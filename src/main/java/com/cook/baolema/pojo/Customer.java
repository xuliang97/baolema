package com.cook.baolema.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private Integer customerID;
    private String customer;
    private String gender;
    private String profilePhoto;
    private String phoneNumber;
    private String password;
    private Float accumulatedAmount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private Integer rank;
}
