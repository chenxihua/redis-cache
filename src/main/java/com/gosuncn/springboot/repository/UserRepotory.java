package com.gosuncn.springboot.repository;

import com.gosuncn.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName: UserRepotory
 * @Create By: chenxihua
 * @Date: 2019/10/21 14:39
 **/
public interface UserRepotory extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    List<User> findAllByUsernameContains(String username);

}
