package com.cook.baolema.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐亮
 * 对响应数据进行封装
 */
@Data
@NoArgsConstructor
public class Result {
    private Integer code;//存放返回数据状态码
    private Object data;//存放返回数据
    private String msg;//存放消息

    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
