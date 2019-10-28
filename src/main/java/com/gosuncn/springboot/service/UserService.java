package com.gosuncn.springboot.service;

import com.gosuncn.springboot.bean.User;
import com.gosuncn.springboot.repository.UserRepotory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName: UserService
 * @Create By: chenxihua
 * @Date: 2019/10/21 11:33
 **/

@Service
@CacheConfig(cacheNames = "user")     // 定义命名空间
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepotory userRepotory;

    public Map<String, Object> saveUser(User user){
        Map<String, Object> result = new HashMap<>();
        User save = userRepotory.save(user);
        result.put("data", save);
        result.put("code", 0);
        return result;
    }

    // 定义缓存时的key
    //  user::com.gosuncn.springboot.service.UserService_selectUser_chen_1_10
    @Cacheable(key = "targetClass.name + '_' + methodName + '_' + #p0 +'_' + #p1 + '_' + #p2")
    public Map<String, Object> selectUser(String name, Integer pageIndex, Integer pageSize){
        Map<String, Object> result = new HashMap<>();
        List<User> all = userRepotory.findAllByUsernameContains(name);
        result.put("data", all+ " " +pageIndex+" "+pageSize);
        result.put("code", 0);
        return result;
    }

    @Caching
    @Cacheable(key = "targetClass.name + '_' + methodName + '_' + #p0")
    public Map<String, Object> selectUserById(Integer id){
        Map<String, Object> result = new HashMap<>();
        Optional<User> optional = userRepotory.findById(id);
        if (optional.isPresent()){
            User user = optional.get();
            result.put("data", user.getDeptBean());
        }
        result.put("code", 0);
        return result;
    }


    @CacheEvict(key = "targetClass.name + '_selectUserById_' + #user.id", condition = "#user.id!=17")
    @Transactional
    public Map<String, Object> updateUser(User user){
        Map<String, Object> result = new HashMap<>();
        User saveAndFlush = userRepotory.saveAndFlush(user);
        result.put("data", saveAndFlush);
        result.put("code", 0);
        return result;
    }

    /**
     * 删除缓存的
     * @param id
     * @return
     */
    @CacheEvict(value = "user", allEntries = true)
    public Map<String, Object> deleteUser(Integer id){
        Map<String, Object> result = new HashMap<>();
        userRepotory.deleteById(id);
        result.put("code", 0);
        return result;
    }




}
