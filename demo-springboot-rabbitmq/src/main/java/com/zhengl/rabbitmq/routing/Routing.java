package com.zhengl.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.pojo.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * routing模式
 *
 * routing模式使用的是Direct（直连）类型的交换机
 * 在routing模式中，将队列和交换机绑定在一起，生成routing key，生产者发送消息时需要指定routing key，交换机会根据routing key将消息投递到与之绑定的队列中
 */
@Slf4j
@Component
public class Routing {

    @RabbitListener(queues = RoutingConfig.ROUTING_QUEUE_1)
    public void routingQueue1(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("routingQueue1.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 routingQueue1.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 routingQueue1.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = RoutingConfig.ROUTING_QUEUE_1)
    public void routingQueue1_2(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("routingQueue1_2.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 routingQueue1_2.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 routingQueue1_2.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = RoutingConfig.ROUTING_QUEUE_2)
    public void routingQueue2(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 睡眠100毫秒
            Thread.sleep(100);
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("routingQueue2.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 routingQueue2.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 routingQueue2.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

    @RabbitListener(queues = RoutingConfig.ROUTING_QUEUE_3)
    public void routingQueue3(MessageBody msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("routingQueue3.msg == {}", msg);
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 routingQueue3.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 routingQueue3.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }
}
