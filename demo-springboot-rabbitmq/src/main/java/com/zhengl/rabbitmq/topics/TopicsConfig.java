package com.zhengl.rabbitmq.topics;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicsConfig {

    public static final String TOPIC_TOPIC_EXCHANGE = "topic_topicExchange";

    public static final String TOPIC_QUEUE_1 = "topicQueue1";
    public static final String TOPIC_QUEUE_2 = "topicQueue2";

    public static final String TOPIC_ROUTING_KEY_1 = "*.topic";
    public static final String TOPIC_ROUTING_KEY_2 = "#.topic";

    // 声明topic类型交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_TOPIC_EXCHANGE);
    }

    // 声明队列
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE_1);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE_2);
    }

    // 将交换机、队列绑定routing key
    @Bean
    public Binding topicBinding(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_ROUTING_KEY_1);
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(TOPIC_ROUTING_KEY_2);
    }

}
