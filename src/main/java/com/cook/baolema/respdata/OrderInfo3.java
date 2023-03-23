package com.cook.baolema.respdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 徐亮
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo3 {
    private Integer orderID;
    private Short status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private Float totalAmount;
    private List<RespOrderDetail4> orderDetailList;
}
