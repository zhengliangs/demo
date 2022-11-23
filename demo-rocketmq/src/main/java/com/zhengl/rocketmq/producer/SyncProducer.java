package com.zhengl.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 同步发送  这种方式只有在消息完全发送完成之后才会返回结果，然后才会继续执行之后的逻辑
 * 同步发送方式内部有重试机制，默认重试2次
 * int timesTotal = communicationMode == CommunicationMode.SYNC ? 1 + this.defaultMQProducer.getRetryTimesWhenSendFailed() : 1;
 * 同步发送会存在 同一个消息可能被多次发送给给broker，需要开发者在消费端处理幂等性问题。
 * @author hero良
 * @description  todo
 * @date 2021/9/27
 **/
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("sync_group");
        producer.setNamesrvAddr("192.168.10.34:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            String msg = "发送同步消息   " + i;
            Message message = new Message("Topic_Sync", "Tag", msg.getBytes(StandardCharsets.UTF_8));
            SendResult send = producer.send(message);
            System.out.println("同步消息发送成功  send == " + send);
        }
        //同步消息需要关闭连接
        producer.shutdown();
    }
}
