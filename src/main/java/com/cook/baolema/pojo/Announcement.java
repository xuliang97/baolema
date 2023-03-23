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

public class Announcement {

    private Integer announcementID;
    private Short status;

    private String url;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createdTime;
}
