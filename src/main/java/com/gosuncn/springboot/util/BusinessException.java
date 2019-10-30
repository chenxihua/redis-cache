package com.gosuncn.springboot.util;

/**
 * @ClassName: BusinessException
 * @Create By: chenxihua
 * @Date: 2019/10/30 11:40
 **/
public class BusinessException extends RuntimeException {

    private static Integer code = -1;

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Integer code){
        super(message);
        this.code = code;
    }

    public static Integer getCode() {
        return code;
    }

    public static void setCode(Integer code) {
        BusinessException.code = code;
    }
}
