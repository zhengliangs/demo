package com.zhengl.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ConfirmListener implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    //消息发送到路由 ack：true表明发送到路由 false表示发送失败
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("confirm correlationData == {}, ack == {}, cause == {}", correlationData, ack, cause);
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("returnedMessage == " + new String(returnedMessage.getMessage().getBody()));
    }
}
