package com.zhengl.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitUtils {

    public static Channel getChannel() throws IOException, TimeoutException {
        //连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.110.21");
        factory.setUsername("admin");;
        factory.setPassword("admin");
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        return connection.createChannel();
    }
}
