package com.zhengl.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 异步发送
 * 异步发送模式在消息发送后立刻返回，不会等待mq返回结果，在消息完全完成发送后，会调用sendCallback来告知本次发送是成功或者失败。
 * 异步模式通常用于对响应时间敏感业务场景，也就是承受不了发送同步消息带来的的时间代价；
 *
 * 异步发送模式不会重试
 * @author hero良
 * @description  todo
 * @date 2021/9/27
 **/
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("async_group");
        producer.setNamesrvAddr("192.168.10.21:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            String msg = " 异步消息  " + i;
            Message message = new Message("Topic_Async", "Tag", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallbackImpl());
            System.out.println(i + "   发送完成");
        }
        //异步消息不需要关闭，不然消息会发送失败
//        producer.shutdown();
    }
}
