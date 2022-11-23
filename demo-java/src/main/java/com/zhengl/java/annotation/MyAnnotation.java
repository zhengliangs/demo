package com.zhengl.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    // 参数类型 + 参数名 + () <default>;
    // default为参数的默认值，如果没有默认值，则在使用该注解的时必须显式的为该参数赋值
    // 如果参数名为 value，则在赋值时可以不指定参数名
    String value();

    String[] name() default {""};
}
