package com.cook.baolema.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespOrderDetail {
    private String dishName;
    private Integer number;
    private Float dishAmount;
}
