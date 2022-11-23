package com.zhengl.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author hero良
 */
//需要和指定包名一起使用，不然会解析失败
@Alias("user")
@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String city;
}
