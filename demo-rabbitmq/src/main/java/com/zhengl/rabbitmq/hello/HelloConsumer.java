package com.zhengl.rabbitmq.hello;

import com.rabbitmq.client.*;
import com.zhengl.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class HelloConsumer {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建信道
        Channel channel = RabbitUtils.getChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("consumerTag == " + consumerTag);
            System.out.println(new String(message.getBody()));
        };

        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("consumerTag == " + consumerTag);
        };

        /*
            1. 队列名称
            2. 消费成功之后是否需要自动应答；true表示自动应答 false表示手动应答
         */
        String consume = channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        System.out.println("consume == " + consume);
    }

}
