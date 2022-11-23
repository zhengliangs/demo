package com.zhengl.rocketmq.meaasge;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionMessage {

    public static void main(String[] args) {
        TransactionMQProducer transactionMQProducer = new TransactionMQProducer("transactionGroup");

        transactionMQProducer.setNamesrvAddr("192.168.10.34:9876");

        transactionMQProducer.setTransactionListener(new TransactionListener() {
            //正常事务过程
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                //处理逻辑，失败返回成功，否则返回   LocalTransactionState.ROLLBACK_MESSAGE
                System.out.println("正常事务");
                return LocalTransactionState.COMMIT_MESSAGE;
            }
            //事务补偿过程
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("事务补偿");
                return null;
            }
        });
    }
}
