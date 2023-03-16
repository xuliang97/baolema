package com.cook.baolema.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 徐亮
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAndDishes {
    private Integer categoryID;
    private String imageUrl;
    private String categoryName;
    private List<Dish> dishList;
}
