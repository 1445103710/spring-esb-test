package com.yao.handle.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.yao.handle.util.SerializeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;

/**
 * @className RocketmqConsumer
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/12 16:22
 */
@Service
@Slf4j
public class RocketmqConsumer {
    @Service
    @RocketMQMessageListener(topic = "yaoyao", consumerGroup = "consumer_topic-queue-two")
    public class ConsumerTwo implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            log.info("############################################");
            log.info("consumer-two received message: {}", message);
            log.info("############################################");
        }
    }
    public static byte[] toByteArray(String hexString) {
        if (StringUtils.isEmpty(hexString))
            throw new IllegalArgumentException("this hexString must not be empty");

        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }
}
