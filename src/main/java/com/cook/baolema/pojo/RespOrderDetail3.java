package com.cook.baolema.pojo;

import com.cook.baolema.pojo.OrderInfo2;
import com.cook.baolema.pojo.RespOrderDetail;
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
