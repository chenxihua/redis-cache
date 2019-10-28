package com.gosuncn.springboot.repository;

import com.gosuncn.springboot.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName: DeptRepository
 * @Create By: chenxihua
 * @Date: 2019/10/23 11:36
 **/
public interface DeptRepository extends JpaRepository<Dept, Integer>, JpaSpecificationExecutor<Dept> {


    List<Dept> findAllByNameContains(String names);

}
