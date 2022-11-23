package com.zhengl.designmode.facade;

/**
 * 动物外观类
 * @author hero良
 */
public class AnimalFacade {

    private Animal bird;
    private Animal dog;
    private Animal cat;

    public AnimalFacade() {
        this.bird = new Bird();
        this.dog = new Dog();
        this.cat = new Cat();
    }

    // 把所有需要调用的子系统，都放在外观类中来调用，简化客户端的调用和减少客户端的依赖
    public void startDraw(){
        this.bird.draw();
        this.dog.draw();
        this.cat.draw();
    }
}
