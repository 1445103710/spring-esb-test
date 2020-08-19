package com.yao.springboottest.java8;

import java.io.*;

/**
 * @className TestCron
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/07/06 19:49
 */
public class TestCron {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/file/cron.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println("###能力平台定时任务");// 往文件里写入字符串

        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <60 ; j++) {
                ps.append("* 0,1,2,3,4,5,6,7,21,22,23 * * * sleep "+j+"; sh /app/ability/cron/timout.sh>>/app/ability/cron/timeout.log"+j+"\n");
            }
        }
        ps.close();
    }
}
