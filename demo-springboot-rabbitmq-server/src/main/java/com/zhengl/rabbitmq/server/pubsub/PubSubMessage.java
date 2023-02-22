package com.zhengl.rabbitmq.server.pubsub;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pubsub")
public class PubSubMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertAndSend")
    public void convertAndSend(){
        for (int i = 0; i < 1; i++) {
            // 根据交换机发送消息，交换机会将消息投递到与自己绑定的队列中，不需要指定routing key路由键
            JSONObject msg = new JSONObject();
            msg.put("pubsub", "发布订阅");
            rabbitTemplate.convertAndSend(PubSubConfig.PUBSUB_FANOUT_EXCHANGE, "", msg);
        }
    }
}
