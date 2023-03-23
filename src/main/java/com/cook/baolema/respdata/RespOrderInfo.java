package com.cook.baolema.respdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespOrderInfo {
    private Integer orderId;
    private Short status;
    private List<RespOrderDetail> orderDetailList;
    private Float totalAmount;

}
