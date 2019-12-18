package com.yao.springbootmq.handle;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @className RabbbitMqConsumer
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/12/18 12:47
 */
@RabbitListener(queues = "yaoyao_queue")
@Component
public class RabbbitMqConsumer2 {
    @RabbitHandler
    public void process(String msg){
        System.out.println("......dddd........receiver: "+msg);
    }
}
