package com.zhengl.rabbitmq.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {

    public static final String SIMPLE = "simple";

    @Bean("simpleBean")
    public Queue simpleQueue(){
        // name:队列名称
        // durable:是否持久化,默认是true。
        // exclusive:排他队列，默认是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。
        // autoDelete:是否自动删除，默认false，当没有生产者或者消费者使用此队列，该队列会自动删除。

        return new Queue(SIMPLE);
    }
}
