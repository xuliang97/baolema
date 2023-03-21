package com.cook.baolema.respdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespOrderDetail3 {
    private OrderInfo2 orderInfo2;
    private List<RespOrderDetail> respOrderDetailList;

}
