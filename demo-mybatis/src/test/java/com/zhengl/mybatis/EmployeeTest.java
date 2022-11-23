package com.zhengl.mybatis;

import com.zhengl.mybatis.mapper.EmployeeMapper;
import com.zhengl.mybatis.pojo.Employee;
import com.zhengl.mybatis.utils.MybatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author hero良
 */
public class EmployeeTest {

    /**
     * 使用构造器 Constructor 映射结果集
     * @author hero良
     */
    @Test
    public void testConstructor(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = mapper.testConstructor();
        employeeList.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * Association的select案例
     * @author hero良
     */
    @Test
    public void testAssociation(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = mapper.testAssociation();
        employeeList.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * Association的ResultMap案例
     * @author hero良
     */
    @Test
    public void testAssociationResult(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = mapper.testAssociationResult();
        employeeList.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * 测试一级缓存
     * @author hero良
     */
    @Test
    public void testOneCache(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList = mapper.findByDeptId(1);

        System.out.println("*************************************");
        int i = mapper.updateEmployeeSalary(9500.0, 2);

        List<Employee> employeeList2 = mapper.findByDeptId(1);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试二级缓存
     * @author hero良
     */
    @Test
    public void testTwoCache(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = mapper.findByDeptId(1);
        //二级缓存需要提交之后才会进入缓存中
        sqlSession.commit();

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);

        List<Employee> employeeList2 = mapper2.findByDeptId(1);
        sqlSession2.commit();

        sqlSession.close();
        sqlSession2.close();
    }

}
