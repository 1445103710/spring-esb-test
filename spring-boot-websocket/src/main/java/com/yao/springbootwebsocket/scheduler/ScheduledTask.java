package com.yao.springbootwebsocket.scheduler;

import com.yao.springbootwebsocket.cache.CacheList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimerTask;

/**
 * @className ScheduledTask
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/09/15 20:50
 */
@Component
@Slf4j
public class ScheduledTask {

    @Scheduled(cron = "0 0 1 * * ?") //每10秒执行一次
//    @Scheduled(cron = "0/10 * * * * ?") //每10秒执行一次
    public void scheduledTaskByCorn() {
        log.info("定时任务开始 ByCorn：" + LocalDateTime.now());
        CacheList.clearCache();
        log.info("定时任务结束 ByCorn：" + LocalDateTime.now());
    }
}
