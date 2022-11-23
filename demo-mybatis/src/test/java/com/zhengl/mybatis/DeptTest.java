package com.zhengl.mybatis;

import com.zhengl.mybatis.mapper.DeptMapper;
import com.zhengl.mybatis.pojo.Dept;
import com.zhengl.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author hero良
 * @classname DeptTest
 */
public class DeptTest {

    /**
     * 测试Collection
     * @author hero良
     */
    @Test
    public void testCollection(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        List<Dept> employeeList = mapper.findDeptInfo();
        employeeList.forEach(System.out::println);

        sqlSession.clearCache();
        sqlSession.close();
    }

    /**
     * 测试Discriminator识别器
     * @author hero良
     */
    @Test
    public void testDiscriminator(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        List<Dept> employeeList = mapper.findAllDept();
        employeeList.forEach(System.out::println);

        sqlSession.close();
    }
}
