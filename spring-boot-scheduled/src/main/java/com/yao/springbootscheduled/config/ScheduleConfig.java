package com.yao.springbootscheduled.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * @className ScheduleConfig
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/15 11:20
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(newScheduledThreadPool(5));
    }
}
