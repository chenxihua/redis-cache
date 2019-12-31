package com.gosuncn.springboot;

import com.gosuncn.springboot.bean.Dept;
import com.gosuncn.springboot.bean.User;
import com.gosuncn.springboot.repository.DeptRepository;
import com.gosuncn.springboot.repository.UserRepotory;
import com.gosuncn.springboot.service.DeptService;
import com.gosuncn.springboot.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @ClassName: RedisTest
 * @Create By: chenxihua
 * @Date: 2019/10/23 11:18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Autowired
    UserService userService;
    @Autowired
    DeptRepository deptRepository;
    @Autowired
    UserRepotory userRepotory;

    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("192.168.244.131", 6379);
        jedis.auth("zhanj201506");
        //jedis.set("zhong", "my laopo");
        String zhong = jedis.get("zhong");
        System.out.println("==> "+zhong);
    }


    @Test
    public void testSave(){
        Dept dept = deptRepository.getOne(3);
        User user = new User();
        user.setUsername("chenxihua");
        user.setPassword("123456");
        user.setHigh(189);
        user.setDeptBean(dept);
        Map<String, Object> stringObjectMap = userService.saveUser(user);
        System.out.println("==> "+stringObjectMap.toString());
    }


    @Test
    public void testRepository(){
        String str = "李四";

        User one = userRepotory.getOne(5);
        //boolean equals = StringUtils.equals(str, one.getUsername());
        System.out.println(one);
    }

}
