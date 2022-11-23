package com.zhengl.designmode.builder.classic;

/**
 * @author hero良
 */
public class Computer {

    private String computerModel;
    private CPU cpu;
    private double length;
    private double width;
    private double height;

    // 可以使用多个构造器来满足computer的初始化，
    // 但是客户端的可读性就会非常差
    private Computer(){}

    // Builder模式可以解决这个问题
    public static class Builder{
        // 初始化Computer
        private Computer computer = new Computer();

        private String computerModel;
        private CPU cpu;
        private double length;
        private double width;
        private double height;

        public Builder computerModel(String computerModel){
            computer.computerModel = computerModel;
            return this;
        }

        public Builder cpu(String model, String manufacturer){
            computer.cpu = new CPU(model, manufacturer);
            return this;
        }

        public Builder length(double length){
            computer.length = length;
            return this;
        }

        public Builder width(double width){
            computer.width = width;
            return this;
        }

        public Builder height(double height){
            computer.height = height;
            return this;
        }

        //将电脑实例返回
        public Computer build(){
            return computer;
        }
    }
}

class CPU {
    private String model;
    private String manufacturer;

    public CPU(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }
}
