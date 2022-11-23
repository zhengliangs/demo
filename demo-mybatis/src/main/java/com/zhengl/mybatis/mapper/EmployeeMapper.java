package com.zhengl.mybatis.mapper;

import com.zhengl.mybatis.pojo.Employee;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author hero良
 */
public interface EmployeeMapper {

    List<Employee> testConstructor();

    List<Employee> testAssociation();

    List<Employee> testAssociationResult();

    List<Employee> findByDeptId(Integer deptId);

    int updateEmployeeSalary(@Param("salary") Double salary, @Param("id") Integer id);
}
