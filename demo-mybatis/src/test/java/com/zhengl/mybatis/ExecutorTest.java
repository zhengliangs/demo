package com.zhengl.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ExecutorTest {

    private Configuration configuration;
    private Connection connection;
    private JdbcTransaction jdbcTransaction;

    private SqlSessionFactory sqlSessionFactory;


    @Before
    public void init() throws IOException, SQLException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
//        configuration = sqlSessionFactory.getConfiguration();
//        connection = DriverManager.getConnection("jdbc:mysql://192.168.110.36:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=UTF-8",
//                "root", "123456");
//        jdbcTransaction = new JdbcTransaction(connection);
    }

    @Test
    public void sessionTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<Object> list = sqlSession.selectList("com.zhengl.mapper.UserMapper.selectById", 1);
        System.out.println(list);

    }


}
