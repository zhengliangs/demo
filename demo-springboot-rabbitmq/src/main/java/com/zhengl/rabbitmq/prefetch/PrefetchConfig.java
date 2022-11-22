package com.zhengl.rabbitmq.prefetch;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrefetchConfig {

    public static final String PREFETCH = "prefetch";

    @Bean
    public Queue prefetchQueue(){
        return new Queue(PREFETCH);
    }
}
