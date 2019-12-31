package com.gosuncn.springboot;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @ClassName: OtherTest
 * @Create By: chenxihua
 * @Date: 2019/10/31 17:10
 **/
public class OtherTest {


    @Test
    public void testStr(){
        String chen = "3";
        String zhong = "3";
        boolean equals = StringUtils.equals(chen, zhong);
        System.out.println(equals);
    }


}
