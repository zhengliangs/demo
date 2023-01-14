package com.zhengl.rabbitmq.server.topics;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicsMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/30
     */
    @PostMapping("/convertAndSend")
    public void convertAndSend(){
        JSONObject msg = new JSONObject();
        msg.put("routing key", "test.topic");
        rabbitTemplate.convertAndSend(TopicsConfig.TOPIC_TOPIC_EXCHANGE, "test.topic", msg);
    }

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/30
     */
    @PostMapping("/convertAndSend1")
    public void convertAndSend1(){
        JSONObject msg = new JSONObject();
        msg.put("routing key", "test.topic");
        rabbitTemplate.convertAndSend(TopicsConfig.TOPIC_TOPIC_EXCHANGE, "test.t.topic", msg);
    }
}
