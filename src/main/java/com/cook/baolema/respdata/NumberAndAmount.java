package com.cook.baolema.respdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐亮
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumberAndAmount {
    private Integer orderNumberOfToday;
    private Double orderAmountOfToday;

}
