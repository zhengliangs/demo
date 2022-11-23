package com.zhengl.designmode.builder.standard;

/**
 * 具体的建造者，实现抽象建造者，构建产品的各部件
 * @author hero良
 */
public class MobikeIBikeBuilder implements IBikeBuilder {

    private Bike bike = new Bike();

    @Override
    public void setFrame() {
        bike.setFrame("Mobike  合金架构");
    }

    @Override
    public void setSeat() {
        bike.setSeat("Mobike  真皮座椅");
    }

    @Override
    public void setTire() {
        bike.setTire("Mobike  米其林轮胎");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
