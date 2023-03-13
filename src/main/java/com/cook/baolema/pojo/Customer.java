package com.cook.baolema.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Customer {
    private Integer customerID;
    private String customer;
    private String gender;
    private String profilePhoto;
    private String phoneNumber;
    private String password;
    private Float accumulatedAmount;
    private Date createdTime;
}
