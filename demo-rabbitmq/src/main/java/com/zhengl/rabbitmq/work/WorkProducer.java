package com.zhengl.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.zhengl.rabbitmq.utils.RabbitUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author hero良
 * @date 2021/11/8
 *
 * 批量生产消息，由多个消费者来轮询消费
 **/
public class WorkProducer {

    public static final String QUEUE_NAME = "work1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取信道
        Channel channel = RabbitUtils.getChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 得到控制台输入的信息
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            String message = scanner.next();
//            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//            System.out.println("******消息发送完毕******");
//        }

        for (int i = 0; i < 3000; i++) {
            String message = " hello world";
            message += i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }
    }

}
