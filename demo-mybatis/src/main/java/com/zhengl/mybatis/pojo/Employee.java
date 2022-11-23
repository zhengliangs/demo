package com.zhengl.mybatis.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * @author hero良
 */
@Data
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Double salary;
    private String sex;
    private Integer deptId;

    private Dept dept;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(Integer id, String name, Double salary, String sex, Integer deptId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.deptId = deptId;
    }
}
