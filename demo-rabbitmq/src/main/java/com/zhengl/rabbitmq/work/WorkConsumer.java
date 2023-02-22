package com.zhengl.rabbitmq.work;

import com.rabbitmq.client.*;
import com.zhengl.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hero良
 * @date 2021/11/8
 *
 * 启动多个消费者实例，来轮询消费消息
 **/
public class WorkConsumer {

    public static final String QUEUE_NAME = "work1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取信道
        Channel channel = RabbitUtils.getChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到消息 == " + new String(message.getBody()));
        };

        CancelCallback cancelCallback = System.out::println;

        System.out.println("消费者  1  等待接收消息......");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }

}
