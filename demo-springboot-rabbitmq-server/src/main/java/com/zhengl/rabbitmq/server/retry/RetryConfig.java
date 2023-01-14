package com.zhengl.rabbitmq.server.retry;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfig {

    public static final String RETRY = "retry";

    @Bean
    public Queue retryQueue(){
        return new Queue(RETRY);
    }
}
