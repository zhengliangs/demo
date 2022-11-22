package com.zhengl.rabbitmq.lazy;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LazyConfig {

    public static final String LAZY_QUEUE = "lazy_queue";
    public static final String LAZY_EXCHANGE = "lazy_exchange";
    public static final String LAZY_ROUTING_KEY = "lazy_routing_key";

    public static final String ORDER_QUEUE = "order_queue";
    public static final String ORDER_EXCHANGE = "order_exchange";
    public static final String ORDER_ROUTING_KEY = "order_routing_key";

    // 延迟队列
    @Bean
    public Queue lazyQueue() {
        return new Queue(LAZY_QUEUE);
    }

    // 延迟交换机
    @Bean
    public DirectExchange lazyExchange() {
        return new DirectExchange(LAZY_EXCHANGE);
    }

    // 延迟路由键
    @Bean
    public Binding bindLazyQueue() {
        return BindingBuilder.bind(lazyQueue()).to(lazyExchange()).with(LAZY_ROUTING_KEY);
    }

    // 业务队列
    @Bean
    public Queue orderQueue() {
        Map<String, Object> args = new HashMap<>(5);
        // 指定的死信交换机
        args.put("x-dead-letter-exchange", LAZY_EXCHANGE);
        // 指定死信路由键
        args.put("x-dead-letter-routing-key", LAZY_ROUTING_KEY);
        // 设定消息的TTL，单位为ms
        args.put("x-message-ttl", 5000);
        return new Queue(ORDER_QUEUE, true, false, false, args);
    }

    // 声明正常工作的交换机 order_exchange
    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(ORDER_EXCHANGE);
    }

    // 订单路由键
    @Bean
    public Binding bindOrderQueue() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(ORDER_ROUTING_KEY);
    }
}
