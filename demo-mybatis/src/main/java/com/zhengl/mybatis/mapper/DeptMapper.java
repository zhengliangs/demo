package com.zhengl.mybatis.mapper;

import com.zhengl.mybatis.pojo.Dept;

import java.util.List;

/**
 * @author hero良
 */
public interface DeptMapper {

    List<Dept> findDeptInfo();

    List<Dept> findAllDept();

}
