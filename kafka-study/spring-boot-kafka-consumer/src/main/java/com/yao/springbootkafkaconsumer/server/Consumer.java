package com.yao.springbootkafkaconsumer.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @className Consumer
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/19 12:52
 */
@Component
@Slf4j
public class Consumer {

    @KafkaListener(id = "cc", topics = "msg")
    public void listen(String msgData) {
        log.info("获取消费消息:"+msgData);
    }
}
