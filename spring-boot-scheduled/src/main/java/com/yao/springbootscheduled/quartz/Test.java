package com.yao.springbootscheduled.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/04/28 16:24
 */
public class Test {
    public static void main(String[] args) throws SchedulerException {
        //1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-scheduled/src/main/resources/quartz.properties");
        //2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();
        scheduler.getContext().put("skey", "svalue");

        //3.创建JobDetail

        JobDataMap jobDataMap1 = new JobDataMap();
        jobDataMap1.put("j1","3333");
        jobDataMap1.put("j2","4444");
        JobDetail jb = JobBuilder.newJob(HelloJob.class)
                .withDescription("this is a ram job") //job的描述
                .withIdentity("ramJob", "ramGroup") //job 的name和group
                .usingJobData(jobDataMap1)
                .build();

        //任务运行的时间，SimpleSchedle类型触发器有效
        long time = System.currentTimeMillis() + 3 * 1000L; //3秒后启动任务
        Date statTime = new Date(time);

        JobDataMap jobDataMap2 = new JobDataMap();
        jobDataMap2.put("t1","1111");
        jobDataMap2.put("t2","2222");

        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity("ramTrigger", "ramTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  //默认当前时间启动
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                .usingJobData(jobDataMap2)
                .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);//源码分析
        //6.启动 调度器
        scheduler.start();
    }
}
