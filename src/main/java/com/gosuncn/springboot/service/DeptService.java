package com.gosuncn.springboot.service;

import com.gosuncn.springboot.bean.Dept;
import com.gosuncn.springboot.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: DeptService
 * @Create By: chenxihua
 * @Date: 2019/10/23 11:37
 **/
@CacheConfig(cacheNames = "dept")
@Service
public class DeptService {

    @Autowired
    DeptRepository deptRepository;


    @Cacheable(key = "targetClass.name + '_' + methodName")
    public Map<String, Object> selectByAll(){
        Map<String, Object> result = new HashMap<>();
        List<Dept> all = deptRepository.findAll();
        result.put("code", 0);
        result.put("data", all);
        return result;
    }


    @Cacheable(key = "targetClass.name + '_' + methodName + '_' + #p0")
    public Map<String, Object> selectByNames(String names){
        Map<String, Object> result = new HashMap<>();
        List<Dept> all = deptRepository.findAllByNameContains(names);
        result.put("code", 0);
        result.put("data", all);
        return result;
    }

    @Cacheable(key = "targetClass.name + '_' + methodName + '_' + #p0")
    public Map<String, Object> selectById(Integer id){
        Map<String, Object> result = new HashMap<>();
        Optional<Dept> byId = deptRepository.findById(id);
        if (byId.isPresent()){
            Dept dept = byId.get();
            result.put("data", dept);
        }
        result.put("code", 0);
        return result;
    }



    public Map<String, Object> savaDept(Dept dept){
        Map<String, Object> result = new HashMap<>();
        Dept save = deptRepository.save(dept);
        result.put("code", 0);
        result.put("data", save);
        return result;
    }

    @CachePut(key = "targetClass.name + '_selectById_' + #dept.id")
    @Transactional
    public Map<String, Object> updateDept(Dept dept){
        Map<String, Object> result = new HashMap<>();
        Dept andFlush = deptRepository.saveAndFlush(dept);
        result.put("code", 0);
        result.put("data", andFlush);
        return result;
    }


    @Caching(evict = {@CacheEvict(key = "targetClass.name + '_selectById_' + #p0"), @CacheEvict(value = "user", allEntries = true)})
    public Map<String, Object> deleteDept(Integer id){
        Map<String, Object> result = new HashMap<>();
        deptRepository.deleteById(id);
        result.put("code", 0);
        return result;
    }




}
