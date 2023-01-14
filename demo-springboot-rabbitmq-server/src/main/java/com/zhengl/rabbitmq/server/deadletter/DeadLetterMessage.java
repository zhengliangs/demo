package com.zhengl.rabbitmq.server.deadletter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dlx")
public class DeadLetterMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * 将消息发送到 business_queue 队列中
     * @author hero良
     * @date 2022/4/30
     */
    @PostMapping("/convertAndSend")
    public void convertAndSend(){
        JSONObject msg = new JSONObject();
        msg.put("queue", "dlx");
        rabbitTemplate.convertAndSend(DeadLetterConfig.BUSINESS_EXCHANGE, DeadLetterConfig.BUSINESS_ROUTING_KEY, msg);
    }
}
