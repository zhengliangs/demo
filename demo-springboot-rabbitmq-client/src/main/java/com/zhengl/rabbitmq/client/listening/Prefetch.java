package com.zhengl.rabbitmq.client.listening;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.client.config.QueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Prefetch {

    @RabbitListener(queues = QueueConstant.PREFETCH)
    public void prefetch(String msg, Channel channel, Message message){
        if(msg == null){
            return;
        }
        log.info("  prefetch.当前线程是 ： {}", Thread.currentThread().getName());
        log.info("  prefetch   do something  msg = {}", msg);
    }

    @RabbitListener(queues = QueueConstant.PREFETCH)
    public void prefetch_1(String msg, Channel channel, Message message){
        if(msg == null){
            return;
        }
        log.info("  prefetch_1.当前线程是 ： {}",Thread.currentThread().getName());
        log.info("  prefetch_1   do something  msg = {}", msg);
    }

}
