package com.zhengl.java.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 反射
 * @author hero良
 * @classname Reflection
 */
public class Reflection {

    public static void main(String[] args) throws Exception {
        Class<?> clazz1 = Class.forName("com.zhengl.reflection.UserPojo");
        System.out.println(clazz1.hashCode());
        // 类的全名称 包名 + 类名
        String name = clazz1.getName();
        System.out.println("name == " + name);
        // 类的简称
        String simpleName = clazz1.getSimpleName();
        System.out.println("simpleName == " + simpleName);
        // 类的修饰符
        int modifiers = clazz1.getModifiers();
        System.out.println("modifiers == " + modifiers);


        // 实现的接口
        Class<?>[] interfaces = clazz1.getInterfaces();
        System.out.println("interfaces == " + interfaces.length);
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface == " + anInterface);
        }

        // 注解
        Annotation[] annotations = clazz1.getAnnotations();
        System.out.println("annotations.length == " + annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println("annotation == " + annotation);
            System.out.println(annotation.annotationType());
        }

    }

    @Test
    public void testConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz1 = Class.forName("com.zhengl.reflection.UserPojo");

        // 获取指定的构造器
        Constructor<?> constructor = clazz1.getConstructor(int.class, String.class, int.class);
        System.out.println("constructor == " + constructor);

        // 构造器
        Constructor<?>[] constructors = clazz1.getConstructors();
        System.out.println("constructors == " + constructors.length);
        for (Constructor<?> constructor1 : constructors) {
            System.out.println("constructor == " + constructor1);
        }

        // 已声明的构造器，忽略访问修饰符
        Constructor<?>[] declaredConstructors = clazz1.getDeclaredConstructors();
        System.out.println("declaredConstructors.length == "+declaredConstructors.length);
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor == "+declaredConstructor);
        }
    }

    @Test
    public void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz1 = Class.forName("com.zhengl.reflection.UserPojo");

        // 获取指定字段，如果指定字段不存在，则抛出异常
        Field assignField = clazz1.getDeclaredField("name");
        System.out.println("assignField == " + assignField);

        Object pojo = clazz1.newInstance();

        // 获取 public 修饰的字段
        Field[] fields = clazz1.getFields();
        System.out.println("fields.length == " + fields.length);
        for (Field field : fields) {
            System.out.println("field == " + field);
        }

        // 获取所有字段，忽略访问修饰符
        Field[] declaredFields = clazz1.getDeclaredFields();
        System.out.println("declaredFields.length == " + declaredFields.length);
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField == " + declaredField);
            // 属性是否是静态属性
            if(Modifier.isStatic(declaredField.getModifiers())){
                System.out.println(declaredField.getName() + " 是静态属性");
                System.out.println("level 修改前 == " + declaredField.getInt(pojo));
                //通过 set 方法修改属性的值
                declaredField.set(pojo, 8);
                System.out.println("level 修改后 == " + declaredField.getInt(pojo));
            }
        }
    }

    @Test
    public void testMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz1 = Class.forName("com.zhengl.reflection.UserPojo");

        // 获取指定方法
        Method setName = clazz1.getDeclaredMethod("setName", String.class);
        System.out.println("setName == " + setName.getName());
        // 实例化对象
        Object pojo = clazz1.newInstance();
        // 通过Method.invoke调用 setName 方法给属性赋值
        setName.invoke(pojo, "郑良");
        System.out.println(pojo.toString());

        // 获取 public 修饰的方法，包含父类的
        Method[] methods = clazz1.getMethods();
        System.out.println("methods.length == " + methods.length);
        for (Method method : methods) {
            System.out.println("method == " + method);
        }

        // 获取当前类中定义的的方法，忽略访问修饰符
        Method[] declaredMethods = clazz1.getDeclaredMethods();
        System.out.println("declaredMethods.length == "+declaredMethods.length);
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod == " + declaredMethod);

            if(Modifier.isStatic(declaredMethod.getModifiers())){
                System.out.println(declaredMethod.getName() + " 是静态方法");
            }
        }
    }
}

