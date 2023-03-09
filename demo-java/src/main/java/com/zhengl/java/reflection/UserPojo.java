package com.zhengl.java.reflection;

import com.zhengl.java.annotation.MyAnnotation;

/**
 * @author hero良
 * @classname UserPojo
 */
@MyAnnotation("zhengl")
public class UserPojo {
    public static int level = 4;

    private int id;

    private String name;

    private int age;

    public UserPojo() {
    }

    public UserPojo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private static void test(){

    }
}
