package com.zhengl.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.zhengl.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class HelloProducer {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取信道
        Channel channel = RabbitUtils.getChannel();
        /*
            1. 队列名称
            2. durable: 队列中的消息是否持久化（磁盘）默认情况消息保存在内存中,RabbitMQ重启后消息就会丢失;
            3. exclusive: 设置是否排他;
            4. autoDelete: 设置在消费完成是否自动删除队列;
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 发送消息
        String message = "hello world";
        // MessageProperties.PERSISTENT_TEXT_PLAIN 用来持久化队列中的消息
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println("******消息发送完毕******");
    }

}
