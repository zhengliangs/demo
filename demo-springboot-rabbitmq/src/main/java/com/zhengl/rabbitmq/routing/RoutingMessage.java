package com.zhengl.rabbitmq.routing;

import com.zhengl.rabbitmq.pojo.MessageBody;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routing")
public class RoutingMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertAndSend1")
    public void convertAndSend1(){
        for (int i = 0; i < 1; i++) {
            MessageBody messageBody = new MessageBody("routing模式", i);
            //需要指定交换机和routing key路由键，交换机会根据routing key将消息投递到对应的队列中
            //队列1和队列3都绑定到了routing1上，所以队列1和队列3都会收到消息
            rabbitTemplate.convertAndSend(RoutingConfig.ROUTING_DIRECT_EXCHANGE, RoutingConfig.ROUTING_1, messageBody);
        }
    }

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertAndSend2")
    public void convertAndSend2(){
        for (int i = 0; i < 10; i++) {
            MessageBody messageBody = new MessageBody("routing模式", i);
            rabbitTemplate.convertAndSend(RoutingConfig.ROUTING_DIRECT_EXCHANGE, RoutingConfig.ROUTING_2, messageBody);
        }
    }
}
