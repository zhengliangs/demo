package com.zhengl.designmode.builder.standard;

/**
 * 标准建造者模式
 * @author hero良
 */
public class ClientBuilder {

    public static void main(String[] args) {
        // 创建指挥者实例，告诉指挥者需要的产品
        Director ofo = new Director(new OfoIBikeBuilder());
        // 指挥者返回客户要的产品，具体的创建过程客户不需要知道
        Bike ofoBike = ofo.construct();
        System.out.println(ofoBike.toString());

        Director mobike = new Director(new MobikeIBikeBuilder());
        Bike mobikeBike = mobike.construct();
        System.out.println(mobikeBike.toString());
    }
}
