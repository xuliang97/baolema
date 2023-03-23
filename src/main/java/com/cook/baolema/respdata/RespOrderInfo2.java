package com.cook.baolema.respdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespOrderInfo2 {
    private Integer orderId;
    private Short status;
    private List<RespOrderDetail2> orderDetailList2;
    private Float totalAmount;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;
    private String uuid;
}
