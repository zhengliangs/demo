package com.zhengl.designmode.builder.standard;

/**
 * 抽象建造者，定义了产品的建造过程
 * @author hero良
 */
public interface IBikeBuilder {

    void setFrame();

    void setSeat();

    void setTire();

    Bike createBike();
}
