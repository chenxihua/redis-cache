package com.gosuncn.springboot.service;

import com.gosuncn.springboot.bean.User;
import com.gosuncn.springboot.repository.UserRepotory;
import com.gosuncn.springboot.util.AsserUtil;
import com.gosuncn.springboot.util.BusinessException;
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
@CacheConfig(cacheNames = {"user", "chen"})     // 定义命名空间
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
    // 在@Cacheable 里面设置一个value，还可以指定使用 @CacheConfig(cacheNames = {"user", "chen"}) 里面的哪一个命名空间的缓存
    @Cacheable(value = "user", key = " caches[0].name +'_'+ targetClass.name + '_' + methodName + '_' + #p0 ")
    public Map<String, Object> selectUser(String name){
        Map<String, Object> result = new HashMap<>();
        List<User> all = userRepotory.findAllByUsernameContains(name);
        result.put("data", all);
        result.put("code", 0);
        return result;
    }

    @Cacheable(value = "chen", key = "targetClass.name + '_' + methodName + '_' + #p0")
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

    /**
     * chen::usercom.gosuncn.springboot.service.UserService_selectUser_f_1_10
     * @param user
     * @return
     */
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
     *
     *  1: 第一个注解， @CacheEvict 是只能删除一个名称空间的缓存。
     *  2：第二个注解， @Caching 是可以删除多个名称空间的缓存。
     *
     * @param id
     * @return
     */
    //@CacheEvict(value = "user", allEntries = true)
    @Caching(evict = {@CacheEvict(value = "user", allEntries = true), @CacheEvict(value = "chen", allEntries = true)})
    public Map<String, Object> deleteUser(Integer id){
        Map<String, Object> result = new HashMap<>();
        userRepotory.deleteById(id);
        result.put("code", 0);
        return result;
    }


    /**
     * 这个方法，充分证明了jpa事务回滚方法。
     *
     * 注意： 在@Transactional 注解的方法里面，不可以使用 try-catch语句，要不然，不会抛出运行异常，导致事务不回滚
     *
     * @param a
     * @return
     */
    @Transactional
    public Map<String, Object> asser(long a){
        Map<String, Object> result = new HashMap<>();
        User user = null;
        Optional<User> byId = userRepotory.findById(11);
        if (byId.isPresent()){
            user = byId.get();
        }
        long l = user.getHigh() + a;
        user.setHigh(l);
        userRepotory.saveAndFlush(user);

        AsserUtil.asserTrue(a!=10, "a要等于10，才可以通过");
        result.put("data", l);
        result.put("code", 0);

        return result;
    }



}
