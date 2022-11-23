package com.zhengl.mybatis.mapper;

import com.zhengl.mybatis.pojo.User;
import java.util.List;

/**
 * @author hero良
 */
public interface UserMapper {

    //根据id查询
    User selectById(Integer id);

    //查询所有
    List<User> selectAll();

    //插入
    int insertUser(User user);

    //更新
    int updateUser(User user);

    int deleteUser(int id);
}
