package com.zhengl.rocketmq.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

public class SendCallbackImpl  implements SendCallback {

    @Override
    public void onSuccess(SendResult sendResult) {
        System.out.println("消息发送成功");
    }

    @Override
    public void onException(Throwable e) {
        System.out.println("消息发送失败");
        System.out.println(e);
    }
}
