package com.zhengl.rabbitmq.deadletter;

import com.zhengl.rabbitmq.pojo.MessageBody;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dead")
public class BusinessMessage {

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
        MessageBody messageBody = new MessageBody("dead.convertAndSend", 0);
        rabbitTemplate.convertAndSend(DeadLetterConfig.BUSINESS_EXCHANGE, DeadLetterConfig.BUSINESS_ROUTING_KEY, messageBody);
    }
}
