package com.cook.baolema.respdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishNumber {
    private Integer dishID;
    private String dishName;
    private Integer number;
}
