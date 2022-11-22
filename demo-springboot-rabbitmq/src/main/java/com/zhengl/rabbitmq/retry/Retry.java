package com.zhengl.rabbitmq.retry;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息的重试
 */
@Slf4j
@Component
public class Retry {

    @RabbitListener(queues = "retry")
    public void retry(String msg, Channel channel, Message message){
        log.info("  retry.msg = {}", msg);
        try {
            // 模拟异常
            int i = 100/0;
            log.info("  retry.当前线程是 ： {}", Thread.currentThread().getName());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(" / by zero");
        }
    }
}
