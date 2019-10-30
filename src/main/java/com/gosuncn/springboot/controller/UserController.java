package com.gosuncn.springboot.controller;

import com.gosuncn.springboot.bean.User;
import com.gosuncn.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Create By: chenxihua
 * @Date: 2019/10/21 11:33
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public Map<String, Object> sava(@RequestBody User user){

        return userService.saveUser(user);
    }

    @PutMapping(value = "/update")
    public Map<String, Object> update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/delete")
    public Map<String, Object> delete(@RequestParam Integer id){
        return userService.deleteUser(id);
    }


    @GetMapping(value = "/get")
    public Map<String, Object> select(@RequestParam String username ){
        return userService.selectUser(username);
    }

    @GetMapping(value = "/getById")
    public Map<String, Object> selectById(@RequestParam Integer id){
        return userService.selectUserById(id);
    }



    @GetMapping(value = "/asser")
    public Map<String, Object> testAsserTrue(@RequestParam long a){
        Map<String, Object> result  = new HashMap<>();
        try {
            result = userService.asser(a);
        }catch (Exception e){
            result.put("message", e.getMessage());
        }
        return result;
    }

}
