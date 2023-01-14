package com.zhengl.rabbitmq.server.deadletter;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DeadLetterConfig {

    public static final String DLX_QUEUE = "dlx_queue";
    public static final String DLX_EXCHANGE = "dlx_exchange";
    public static final String DLX_ROUTING_KEY = "dlx_routing_key";

    public static final String BUSINESS_QUEUE = "business_queue";
    public static final String BUSINESS_EXCHANGE = "business_exchange";
    public static final String BUSINESS_ROUTING_KEY = "business_routing_key";

    // 死信队列
    @Bean
    public Queue dlxQueue() {
        return new Queue(DLX_QUEUE);
    }

    // 死信交换机
    @Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange(DLX_EXCHANGE);
    }

    // 死信路由键
    @Bean
    public Binding bindDlxQueue() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(DLX_ROUTING_KEY);
    }

    // 业务队列
    @Bean
    public Queue businessQueue() {
        Map<String, Object> args = new HashMap<>(2);
        // 指定的死信交换机
        args.put("x-dead-letter-exchange", DLX_EXCHANGE);
        // 指定死信路由键
        args.put("x-dead-letter-routing-key", DLX_ROUTING_KEY);
        return new Queue(BUSINESS_QUEUE, true, false, false, args);
    }

    // 声明正常工作的交换机 business_exchange
    @Bean
    public DirectExchange businessExchange() {
        return new DirectExchange(BUSINESS_EXCHANGE);
    }

    // 业务路由键
    @Bean
    public Binding bindBusinessQueue() {
        return BindingBuilder.bind(businessQueue()).to(businessExchange()).with(BUSINESS_ROUTING_KEY);
    }

}
