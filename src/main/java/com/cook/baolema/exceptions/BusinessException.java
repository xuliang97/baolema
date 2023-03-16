package com.cook.baolema.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 徐亮
 * 对程序可能产生的异常进行分类。
 * Business异常（业务异常）指用户行为导致的异常
 * 比如：在页面输入内容时未按指定格式进行书写（如在年龄框输入的是字符串）；
 */

public class BusinessException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}

