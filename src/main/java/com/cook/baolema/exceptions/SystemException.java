package com.cook.baolema.exceptions;

/**
 * @author 徐亮
 * 用于处理系统故障等可预计但是无法避免的异常
 */
public class SystemException extends RuntimeException{
    private Integer code;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
