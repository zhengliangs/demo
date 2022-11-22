package com.zhengl.rabbitmq.lazy;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.pojo.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * RabbitMQ中的延迟队列是借助死信队列和TTL来实现的，将消息路由到没有消费者监听的队列中，并设置消息的过期时间，再消息到达过期时间后，
 * 会被路由到设置好的死信队列，然后会被死信队列的消费者监听到；
 */
@Slf4j
@Component
public class Lazy {

    /**
     * 监听延迟队列
     */
    @RabbitListener(queues = LazyConfig.LAZY_QUEUE)
    public void lazyQueue(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            long time = System.currentTimeMillis() - msg.getTime();
            log.info("lazyQueue.msg == {}, time == {}", msg, time);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 lazyQueue.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 lazyQueue.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }
}
