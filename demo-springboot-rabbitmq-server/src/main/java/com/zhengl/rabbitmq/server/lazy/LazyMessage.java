package com.zhengl.rabbitmq.server.lazy;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
public class LazyMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/5/5
     */
    @PostMapping("/convertAndSend")
    public void convertAndSend(){
        JSONObject msg = new JSONObject();
        msg.put("time", System.currentTimeMillis());
        // 将消息发送到业务队列，但是没有消费者监听，消息在超时后，会被路由到业务队列绑定的延迟队列中，然后被延迟队列的消费者监听到
        rabbitTemplate.convertAndSend(LazyConfig.ORDER_EXCHANGE, LazyConfig.ORDER_ROUTING_KEY, msg, message -> {
            // 设置超时时间 2000ms
            message.getMessageProperties().setExpiration("2000");
            return message;
        });
    }
}
