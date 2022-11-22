package com.zhengl.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.pojo.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * publish/subscribe模式 / 广播模式
 *
 * publish/subscribe模式使用的是fanout（广播）类型的交换机
 * 在publish/subscribe模式中，生产者将消息发送到Broker中，由交换机将消息投递到与之绑定的队列中，
 * 所有和这个交换机绑定的队列都会收到消息（一个队列多个监听者，只有一个监听者会收到消息），不需要指定routing key
 */
@Slf4j
@Component
public class PubSub {

    @RabbitListener(queues = PubSubConfig.PUBSUB_QUEUE_1)
    public void pubsubQueue1(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("pubsubQueue1.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 pubsubQueue1.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 pubsubQueue1.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = PubSubConfig.PUBSUB_QUEUE_1)
    public void pubsubQueue1_2(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("pubsubQueue1_2.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 pubsubQueue1_2.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 pubsubQueue1_2.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = PubSubConfig.PUBSUB_QUEUE_2)
    public void pubsubQueue2(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("pubsubQueue2.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 pubsubQueue2.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 pubsubQueue2.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }
}
