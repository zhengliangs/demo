package com.zhengl.rabbitmq.routing;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    public static final String ROUTING_DIRECT_EXCHANGE = "routing_directExchange";

    public static final String ROUTING_QUEUE_1 = "routingQueue1";
    public static final String ROUTING_QUEUE_2 = "routingQueue2";
    public static final String ROUTING_QUEUE_3 = "routingQueue3";

    public static final String ROUTING_1 = "routing1";
    public static final String ROUTING_2 = "routing2";

    // 声明一个Direct类型的交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(ROUTING_DIRECT_EXCHANGE);
    }

    // 声明队列
    @Bean
    public Queue routingQueue1(){
        return new Queue(ROUTING_QUEUE_1);
    }

    @Bean
    public Queue routingQueue2(){
        return new Queue(ROUTING_QUEUE_2);
    }

    @Bean
    public Queue routingQueue3(){
        return new Queue(ROUTING_QUEUE_3);
    }

    //将队列routingQueue1绑定到交换器上，并指定binding key为routing1
    @Bean
    public Binding routingBinding1(){
        return BindingBuilder.bind(routingQueue1()).to(directExchange()).with(ROUTING_1);
    }

    //将队列routingQueue2绑定到交换器上，并指定binding key为routing2
    @Bean
    public Binding routingBinding2(){
        return BindingBuilder.bind(routingQueue2()).to(directExchange()).with(ROUTING_2);
    }

    //将队列routingQueue3绑定到交换器上，并指定binding key为routing1
    @Bean
    public Binding routingBinding3(){
        return BindingBuilder.bind(routingQueue3()).to(directExchange()).with(ROUTING_1);
    }

}
