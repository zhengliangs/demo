package com.zhengl.rabbitmq.simple;

import com.zhengl.rabbitmq.pojo.MessageBody;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertSendAndReceive 有序的发送消息，只有消息被消费者接收，才会发送下一条消息，每条消息之间会存在时间间隔
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertSendAndReceive")
    public void convertSendAndReceive(){
        for (int i = 0; i < 10; i++) {
            MessageBody messageBody = new MessageBody("simple.convertSendAndReceive", i);
            rabbitTemplate.convertSendAndReceive(SimpleConfig.SIMPLE, messageBody);
        }
    }

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertAndSend")
    public void convertAndSend(){
        for (int i = 0; i < 10; i++) {
            MessageBody messageBody = new MessageBody("simple.convertAndSend", i);
            rabbitTemplate.convertAndSend(SimpleConfig.SIMPLE, messageBody);
        }
    }
}
