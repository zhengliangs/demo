package com.zhengl.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.pojo.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *
 * work有两种消费模式，默认是轮询
 * 1. 轮询分发，一个消费者消费一条，按均分发，work模式下默认是采用轮询分发方式；
 * 2. 公平分发，根据消费者的能力进行分发，处理能力快的分发的多，反之处理慢的分发的少，遵循能者多劳原则；
 *      公平分发需要将消息确认模式改为手动确认，预处理改为每次读取1条消息；
 */
@Slf4j
@Component
public class Work {

    static int work_1 = 1;

    static int work_2 = 1;

    @RabbitListener(queues = WorkConfig.WORK)
    public void work(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("work.msg == {}， 共消费 {}条", msg, work_1++);
            if(work_1 == 50){
                double s = 1/0;
            }
            // 确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 work.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 work.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = WorkConfig.WORK)
    public void work_1(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 睡眠100毫秒,默认处理性能差
            Thread.sleep(100);
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("work_1.msg == {}， 共消费 {}条", msg, work_2++);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 work_1.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 work_1.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }
}
