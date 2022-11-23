package com.zhengl.designmode.builder.standard;

/**
 * 指挥者，决定了产品怎么构建
 * @author hero良
 */
public class Director {

    private IBikeBuilder bikeBuilder;

    public Director(IBikeBuilder bikeBuilder){
        this.bikeBuilder = bikeBuilder;
    }

    // 调用产品各部件的构建方法，最后返回一个产品对象
    public Bike construct(){
        bikeBuilder.setFrame();
        bikeBuilder.setSeat();
        bikeBuilder.setTire();
        return bikeBuilder.createBike();
    }
}
