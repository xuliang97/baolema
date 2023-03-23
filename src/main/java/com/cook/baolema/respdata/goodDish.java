package com.cook.baolema.respdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class goodDish {
    private Integer dishID;
    private Integer dishCount;
    private String dishName;
}
