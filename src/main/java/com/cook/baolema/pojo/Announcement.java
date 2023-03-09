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
public class Announcement {
    private Integer announcementID;
    private Integer status;
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createdTime;
}
