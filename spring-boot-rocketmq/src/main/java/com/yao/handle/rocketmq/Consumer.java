package com.yao.handle.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.yao.handle.util.SerializeUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @className Consumer
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/12 18:08
 */
public class Consumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {

        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");

        // Subscribe one more more topics to consume.
        consumer.subscribe("yaoyao", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                //System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                System.out.println("###############################################");
                System.out.println();
                msgs.forEach((msg)->{
                    byte[] b = msg.getBody();
                    JSONObject j = (JSONObject) SerializeUtils.deserialize(b);
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), j.toJSONString());

                });
                System.out.println("###############################################");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
