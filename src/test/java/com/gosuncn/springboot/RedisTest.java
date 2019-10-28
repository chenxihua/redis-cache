package com.gosuncn.springboot;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: RedisTest
 * @Create By: chenxihua
 * @Date: 2019/10/23 11:18
 **/
public class RedisTest {


    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("192.168.244.131", 6379);
        jedis.auth("zhanj201506");
        //jedis.set("zhong", "my laopo");
        String zhong = jedis.get("zhong");
        System.out.println("==> "+zhong);
    }

}
