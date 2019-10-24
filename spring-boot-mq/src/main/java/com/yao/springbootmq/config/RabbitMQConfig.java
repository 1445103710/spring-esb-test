package com.yao.springbootmq.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className RabbitMQConfig
 * @description: rabbit
 * @author: yaoyao
 * @create: 2019/10/23 21:10
 */
@Configuration
public class RabbitMQConfig {

    static final String QUEUE = "yaoyao_queue";

    @Bean
    public Queue dicQueue() {
        return new Queue(QUEUE, true);
    }
}
