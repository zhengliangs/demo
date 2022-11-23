package com.zhengl.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

public class PullConsumer {

    public static void main(String[] args) throws MQClientException {

        // Instantiate with specified consumer group name.
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer();

        // Specify name server addresses.
        consumer.setNamesrvAddr("192.168.10.34:9876");
        consumer.setMessageModel(MessageModel.CLUSTERING);

        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicTest", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
//        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
//            for (MessageExt msg : msgs) {
//                String str = new String(msg.getBody());
//                System.out.println(str);
//            }
//            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
