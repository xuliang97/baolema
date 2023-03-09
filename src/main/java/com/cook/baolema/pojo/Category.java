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
@ToString
@Setter
@Getter
public class Category {
    private Integer categoryID;
    private String category;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createdTime;
}
