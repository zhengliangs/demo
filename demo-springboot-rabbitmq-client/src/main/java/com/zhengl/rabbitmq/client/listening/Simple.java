package com.zhengl.rabbitmq.client.listening;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.client.config.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Simple {

    @RabbitListener(queues = QueueConstant.SIMPLE)
    public void simple(JSONObject msg, Channel channel, Message message){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            if(msg == null){
                channel.basicAck(deliveryTag, false);
                return;
            }
            log.info("simple.msg == {}", msg);
            // 确认消息
            // boolean multiple: 是否批量确认消息；
            // true：会把信道所有的消息都确认，不管后续的消息是否会被消费成功；
            // false：如果信道中有多个消息，只确认当前消息；
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                if (message.getMessageProperties().getRedelivered()) {
                    log.info("消息已重复处理失败,拒绝再次接收 simple.msg == {}", msg);
                    channel.basicReject(deliveryTag, false);
                } else {
                    log.info("消息即将再次返回队列处理 simple.msg == {}", msg);
                    channel.basicNack(deliveryTag, false, true);
                }
            } catch (IOException e1) {
                log.error(e1.getMessage(), e1);
            }
        }
    }

}
