package com.zhengl.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 单向消息  采用 one-way发送消息时候，发送端在发送完消息之后会立即返回，不会等待broker的ack老返回这次的消息是否发送成功。
 * one-way方式的吞度量大，但是会有消息丢失的风险；所以适合发送不重要的消息，比如日志收集；
 * @author hero良
 * @description  todo
 * @date 2021/9/27
 **/
public class OneWayProducer {

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("oneway_group");
        producer.setNamesrvAddr("192.168.10.34:9876");
        producer.start();

        for (int i = 0; i < 10; i++) {
            String msg = "发送单向消息   " + i;
            Message message = new Message("Topic_oneway", "Tag", msg.getBytes(StandardCharsets.UTF_8));
            producer.sendOneway(message);
        }
        System.out.println("发送完了");
        producer.shutdown();
    }
}
