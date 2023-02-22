package com.zhengl.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitUtils {

    public static Channel getChannel() throws IOException, TimeoutException {
        // 连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.110.36");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("vhost");
        connectionFactory.setUsername("admin");;
        connectionFactory.setPassword("admin");
        // 创建连接
        Connection connection = connectionFactory.newConnection();
        // 获取信道
        return connection.createChannel();
    }
}
