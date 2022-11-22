package com.zhengl.rabbitmq.prefetch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/prefetch")
public class PrefetchMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertSendAndReceive 有序的发送消息，只有消息被消费者接收，才会发送下一条消息，每条消息之间会存在时间间隔
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertSendAndReceive")
    public void convertSendAndReceive(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertSendAndReceive(PrefetchConfig.PREFETCH, "convertSendAndReceive.prefetch  " + i);
        }
        long end = System.currentTimeMillis();
        log.info("convertSendAndReceive 耗时 : {} 秒",(end - start)/1000);
    }

    /**
     * convertAndSend 消息接收的时候是无序的，不管消息是否被消费者接收
     * @author hero良
     * @date 2022/4/29
     */
    @PostMapping("/convertAndSend")
    public void convertAndSend(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            rabbitTemplate.convertAndSend(PrefetchConfig.PREFETCH, "convertAndSend.prefetch  " + i);
        }
        long end = System.currentTimeMillis();
        log.info("convertAndSend 耗时 : {} 秒",(end - start)/1000);
    }
}
