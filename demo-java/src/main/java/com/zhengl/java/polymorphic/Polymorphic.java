package com.zhengl.java.polymorphic;

/**
 * @author hero良
 * @classname Polymorphic
 */
public class Polymorphic {

    /*
        重写
            重写发生在父类和子类中，方法名，参数列表，返回值都必须相同，只有方法的实现可以不同；
            如果父类中抛出了异常，则子类中抛出的异常不可以大于父类；

        重载
            重载发在的同一个类中，方法名称，参数列表和返回值可以不同；

        多态
            向上造型，父类型的引用指向子类型的对象；
            可以使用所有父类中的属性和方法，如果被子类重写了，那么执行的就是子类的中的属性和方法；
            只在子类中的属性和方法，父类型的引用无法访问
     */
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        // Cat fun
        cat.fun();
        // Cat fun1
        cat.fun1();
        System.out.println("-----------------");
        // 1.animal fun 2.Dog fun
        dog.fun();
        // animal fun1
        dog.fun1();
    }

}
