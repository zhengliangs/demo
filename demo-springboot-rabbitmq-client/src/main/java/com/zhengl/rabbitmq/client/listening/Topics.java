package com.zhengl.rabbitmq.client.listening;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.client.config.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * topics模式/动态路由模式
 *
 * topics模式使用的是Topic类型的交换机
 * 在topics模式中，将队列和交换机绑定在一起，生成带有通配符的routing key，生产者发送消息时需要指定routing key，
 * 交换机会根据routing key将消息投递到指定的队列
 *
 * *表示匹配一个单纯
 * #表示匹配多个字符
 *
 * 通配符优先级 * > #
 */
@Slf4j
@Component
public class Topics {

    @RabbitListener(queues = QueueConstant.TOPIC_QUEUE_1)
    public void topicQueue1(String msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("topicQueue1.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 topicQueue1.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 topicQueue1.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = QueueConstant.TOPIC_QUEUE_2)
    public void topicQueue2(String msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("topicQueue2.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 topicQueue2.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 topicQueue2.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }
}
