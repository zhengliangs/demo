package com.zhengl.designmode.facade;

/**
 * 外观模式
 *
 * 外观模式可以提供一个统一的接口来访问子系统中的一个或者多个接口，让客户端对子系统接口的调用更方便；
 *
 * 外观模式的好处就是可以简化复杂接口的调用；减少系统的相互依赖；
 * @author hero良
 * @date 2021/2/26
 */
public class ClientFacade {

	public static void main(String[] args) {
		AnimalFacade facade = new AnimalFacade();
		facade.startDraw();
	}

}
