package com.gosuncn.springboot.util;

/**
 * @ClassName: AsserUtil
 * @Create By: chenxihua
 * @Date: 2019/10/30 11:43
 **/
public class AsserUtil {

    private static final int DEFUALT_ERROR_CODE = -1;

    public static void asserTrue(boolean expression, String message){
        asserTrue(expression, DEFUALT_ERROR_CODE ,message);
    }

    public static void asserTrue(boolean expression, int errorCode ,String message){
        if (!expression){
            throw new  BusinessException(message, errorCode);
        }
    }


}
