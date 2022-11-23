package com.zhengl.java.paramtransfer;

/**
 * 验证java到底是值传递还是引用传递
 * @author hero良
 */
public class ParamTransfer {

    public static void main(String[] args) {
        Person person = new Person("张三", 12);
        System.out.println("修改前 == " + person);
        update(person);
        System.out.println("修改后 == " + person);


        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");

        System.out.println("b.hashCode === " + b.hashCode());
        method(a, b);
        System.out.println("b.hashCode === " + b.hashCode());

        System.out.println(a + "," + b);
    }

    public static void update(Person person){
        person = new Person("李四", 34);
        System.out.println("update == " + person);
    }

    public static void method(StringBuffer a, StringBuffer b){
        a.append(b);
        b = a;
        System.out.println("b.hashCode === " + b.hashCode());
    }
}
