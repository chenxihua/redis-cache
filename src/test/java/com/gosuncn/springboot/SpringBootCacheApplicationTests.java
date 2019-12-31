package com.gosuncn.springboot;

import com.gosuncn.springboot.bean.Dept;
import com.gosuncn.springboot.repository.DeptRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    DeptRepository deptRepository;

    @Test
    public void contextLoads() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Optional<Dept> byId = deptRepository.findById(1);
        if (byId.isPresent()){
            Dept dept = byId.get();
            System.out.println(dept);
            System.out.println("1: "+dept.getName());
            System.out.println("2: "+dept.getTimestamp());
//            System.out.println("type: "+ sdf.format(dept.getTimestamp()).getClass());
//            System.out.println("data: "+sdf.format(dept.getTimestamp()));
        }
        List<Dept> deptList = new ArrayList<>();
        for (Dept dept : deptList) {

        }

    }

    public List<Map<String, Object>> getHH(){
        return null;
    }

}
