package com.zhengl.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.34");
        factory.setUsername("guest");;
        factory.setPassword("guest");
        // 创建连接
        Connection connection = factory.newConnection();
        // 获取信道
        Channel channel = connection.createChannel();
        /*
            1. 队列名称
            2. durable: 队列中的消息是否持久化（磁盘）默认情况消息保存在内存中,RabbitMQ重启后消息就会丢失；true: 持久化到磁盘，false: 不开启持久化
            3. exclusive: 设置是否排他
            4. autoDelete: 设置是否自动删除
         */
        boolean durable = false;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

        // 发送消息
        String message = "hello world";
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println("******消息发送完毕******");
    }

}
