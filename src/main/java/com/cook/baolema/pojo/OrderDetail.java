package com.cook.baolema.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetail {
    private Integer orderDetailID;
    private Integer orderID;
    private Integer dishID;
    private Integer number;
    private Float dishAmount;
}
