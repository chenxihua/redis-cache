package com.gosuncn.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Create By: chenxihua
 * @Date: 2019/10/21 11:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude={"deptBean"})
@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private long high;

    // optional = false 表示可选属性，此时表示dept不能为空。删除用户，不影响部门。
    @JsonIgnore   //  设置@JsonIgnore,这个注解的意思是表示在序列化的时候，忽略这个属性
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "dept_id")  // 设置在dept表中的关联外键
    private Dept deptBean;

}
