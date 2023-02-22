package com.zhengl.rabbitmq.server.pubsub;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubConfig {

    public static final String PUBSUB_FANOUT_EXCHANGE = "pubsub_fanoutExchange";

    public static final String PUBSUB_QUEUE_1 = "pubsubQueue1";
    public static final String PUBSUB_QUEUE_2 = "pubsubQueue2";

    // 声明一个fanout类型的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(PUBSUB_FANOUT_EXCHANGE);
    }

    // 声明两个队列，分别与上面声明的fanout交换机进行绑定
    @Bean
    public Queue pubsubQueue1(){
        return new Queue(PUBSUB_QUEUE_1);
    }

    @Bean
    public Queue pubsubQueue2(){
        return new Queue(PUBSUB_QUEUE_2);
    }

    // 绑定pubsubQueue1
    @Bean
    public Binding pubsubBinding1(){
        return BindingBuilder.bind(pubsubQueue1()).to(fanoutExchange());
    }

    // 绑定pubsubQueue2
    @Bean
    public Binding pubsubBinding2(){
        return BindingBuilder.bind(pubsubQueue2()).to(fanoutExchange());
    }
}
