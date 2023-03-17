package com.cook.baolema.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @author 徐亮
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dish {
    private Integer dishID;
    private String dish;
    private Integer categoryID;
    private String dishPhoto;
    private String description;
    private Float price;
    private Integer inventory;
    private Date createdTime;
    private Integer deleted;
}
