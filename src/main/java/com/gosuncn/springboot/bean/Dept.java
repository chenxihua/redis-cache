package com.gosuncn.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @ClassName: Dept
 * @Create By: chenxihua
 * @Date: 2019/10/23 11:33
 **/
//@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude={"userList"})
@Entity
@Table(name = "dept")
public class Dept implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer peoples;

    private Timestamp timestamp;

    /**
     * mappedBy = "deptBean" 中的 deptBean 是指 User 实体中的 deptBean 属性。
     */
    @JsonIgnore     // 设置@JsonIgnore,这个注解的意思是表示在序列化的时候，忽略这个属性
    @OneToMany(mappedBy = "deptBean", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> userList;


    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", peoples=" + peoples +
                ", timestamp=" + timestamp +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeoples() {
        return peoples;
    }

    public void setPeoples(Integer peoples) {
        this.peoples = peoples;
    }

    public String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}



