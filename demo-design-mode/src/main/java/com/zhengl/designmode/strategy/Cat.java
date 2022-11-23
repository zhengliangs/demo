package com.zhengl.designmode.strategy;

/**
 * @author hero良
 */
public class Cat implements Comparable<Cat>{

    private int height;

    public Cat(int height) {
        this.height = height;
    }


    @Override
    public int compareTo(Cat cat) {
        //当前对象小于要比较的对象，返回1
        if(this.height < cat.height) return -1;
        //当前对象大于要比较的对象，返回-1
        else if(this.height > cat.height) return 1;
        //相等，返回0
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                '}';
    }
}
