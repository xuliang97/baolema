package com.cook.baolema.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespOrderDetail2 {
    private String dishName;
    private String description;
    private Integer number;
    private Float dishAmount;
    private String dishPhoto;
}
