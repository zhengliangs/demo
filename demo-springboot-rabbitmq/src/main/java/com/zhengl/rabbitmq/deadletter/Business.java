package com.zhengl.rabbitmq.deadletter;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.pojo.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 在以下情况，消息会进入绑定的死信队列
 * 1.消息被拒绝消费(basic.reject or basic.nack)并且设置了requeue=false
 * 2.消息在队列的存活时间超过设置的生存时间（TTL)时间。
 * 3.消息队列的消息数量已经超过最大队列长度
 *
 * 业务队列(business_queue)绑定了死信队列(dlx_queue)，业务队列监听到消息，执行业务逻辑抛出了异常，消息没有被正确ACK，最后消息会进入死信队列，
 * 死信队列可以有消费者监听也可以没有消费者监听。
 */
@Slf4j
@Component
public class Business {

    @RabbitListener(queues = DeadLetterConfig.BUSINESS_QUEUE)
    public void businessQueue(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("businessQueue.msg == {}", msg);
            // 模拟异常,拒绝消息
            double dou = 1/0;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 businessQueue.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 businessQueue.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

}
