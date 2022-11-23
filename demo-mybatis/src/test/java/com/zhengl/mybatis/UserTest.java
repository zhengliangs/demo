package com.zhengl.mybatis;

import com.zhengl.mybatis.mapper.UserMapper;
import com.zhengl.mybatis.pojo.User;
import com.zhengl.mybatis.utils.MybatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author hero良
 */
public class UserTest {

    @Test
    public void selectById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
        //关闭回话
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAll();
        userList.forEach(System.out::println);
        //关闭回话
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insertUser(new User(6, "嘻嘻哈哈", 12, "这里"));
        System.out.println(i);
        //提交事务
        sqlSession.commit();
        //关闭回话
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(6, "嘻嘻哈哈2", 12, "这里2"));
        System.out.println(i);
        //提交事务
        sqlSession.commit();
        //关闭回话
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(6);
        System.out.println(i);
        //提交事务
        sqlSession.commit();
        //关闭回话
        sqlSession.close();
    }

}
