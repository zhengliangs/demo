package com.zhengl.designmode.builder.standard;

/**
 * 具体的建造者，实现抽象建造者，构建产品的各部件
 * @author hero良
 */
public class OfoIBikeBuilder implements IBikeBuilder {

    private Bike bike = new Bike();

    @Override
    public void setFrame() {
        bike.setFrame(" ofo 铁架构");
    }

    @Override
    public void setSeat() {
        bike.setSeat(" ofo 布座椅");
    }

    @Override
    public void setTire() {
        bike.setTire(" ofo 真空轮胎");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
