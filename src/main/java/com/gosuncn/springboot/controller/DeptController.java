package com.gosuncn.springboot.controller;

import com.gosuncn.springboot.bean.Dept;
import com.gosuncn.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: DeptController
 * @Create By: chenxihua
 * @Date: 2019/10/23 16:44
 **/
@RestController
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    DeptService deptService;


    @PostMapping(value = "/save")
    public String save(@RequestBody Dept dept){
        Map<String, Object> stringObjectMap = deptService.savaDept(dept);
        return stringObjectMap.toString();
    }


    @GetMapping(value = "/all")
    public String selectAll(){
        Map<String, Object> stringObjectMap = deptService.selectByAll();
        return stringObjectMap.toString();
    }

    @GetMapping(value = "/byId")
    public String selectById(@RequestParam Integer id){
        Map<String, Object> stringObjectMap = deptService.selectById(id);
        return stringObjectMap.toString();
    }

    @GetMapping(value = "/byName")
    public String selectByName(@RequestParam String name){
        Map<String, Object> stringObjectMap = deptService.selectByNames(name);
        return stringObjectMap.toString();
    }


    @PutMapping(value = "/update")
    public String updateDept(@RequestBody Dept dept){
        Map<String, Object> stringObjectMap = deptService.updateDept(dept);
        return stringObjectMap.toString();
    }

    @DeleteMapping(value = "/delete")
    public String deleteDept(@RequestParam Integer id){
        Map<String, Object> stringObjectMap = deptService.deleteDept(id);
        return stringObjectMap.toString();
    }


}
