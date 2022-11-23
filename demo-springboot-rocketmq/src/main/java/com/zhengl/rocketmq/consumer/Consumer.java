package com.zhengl.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 设置消息监听
 * 1.consumerGroup: 配置监听组
 * 2.topic: 配置监听的topic
 * 3.selectorExpression: 配置监听tag, 默认监听topic下所有
 * 4.messageModel: 配置监听消费模式: 默认负载均衡模式;
 *      CLUSTERING: 负载均衡,每一个消息只发给一个消费者; BROADCASTING: 广播模式,发送给所有消费者;
 * 5.consumeMode: 设置顺序消息处理模式, 默认是所有线程可以处理同一个消息队队列;
 *      ConsumeMode.CONCURRENTLY: 所有线程可以处理同一个消息队; ConsumeMode.ORDERLY: 当前消息没有线程在执行时其他线程才能够执行;
 *      ps:一个线程顺序执行一个队列表时消息监听必须使用负载均衡messageModel = MessageModel.BROADCASTING）
 * 6.selectorType: 设置过滤tags类型, 默认是tag;
 *      SelectorType.TAG: 按照tag过滤；,SelectorType.SQL92: 按照sql过滤;
 */
@RocketMQMessageListener(consumerGroup = "group", topic = "topic",
        selectorType = SelectorType.TAG, selectorExpression = "tag",
        messageModel = MessageModel.CLUSTERING, consumeMode = ConsumeMode.CONCURRENTLY, consumeThreadMax = 64)
@Slf4j
@Component
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("Consumer.message == {}", message);
    }
}
