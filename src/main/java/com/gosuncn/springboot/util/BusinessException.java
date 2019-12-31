package com.gosuncn.springboot.util;

/**
 * @ClassName: BusinessException
 * @Create By: chenxihua
 * @Date: 2019/10/30 11:40
 **/
public class BusinessException extends RuntimeException {

    private Integer code = -1;

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Integer code){
        super(message);
        this.code = code;
    }

    public  Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
