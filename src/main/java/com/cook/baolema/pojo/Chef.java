package com.cook.baolema.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Chef {
    private Integer chefID;
    private String chef;
    private String gender;
    private String profilePhoto;
    private String phoneNumber;
    private String password;
    private Date createdTime;
    private Float performance;
}
