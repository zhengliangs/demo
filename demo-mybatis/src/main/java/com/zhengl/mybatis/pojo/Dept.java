package com.zhengl.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author hero良
 */
@Data
public class Dept {

    private Integer id;
    private String name;
    private int useState;

    List<Employee> employeeList;

    public Dept(Integer id) {
        this.id = id;
    }
}
