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
public class Manager {
    private Integer managerID;
    private String manager;
    private String gender;
    private String profilePhoto;
    private String phoneNumber;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date createdTime;
}
