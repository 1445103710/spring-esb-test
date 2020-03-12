package com.yao.springbootmq.handle;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @className RabbbitMqConsumer
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/12/18 12:47
 */
@RabbitListener(bindings = @QueueBinding(
        value = @Queue("yaoyao_queue1"),
        exchange = @Exchange("myExchange")
))
@Component
public class RabbbitMqConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println("......Info........receiver: "+msg);
    }
}
