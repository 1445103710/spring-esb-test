package com.yao.springboottest.java8.mach;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/20 15:09
 */
public class Test {
    private static final Pattern FLINK_ID_REGEX = Pattern.compile("[0-9a-z]{32}");
    public static void main(String[] args) {
        String s = "[INFO] 2020-05-20 16:04:08.801  - [taskAppId=TASK-18-289-845]:[127] -  -> Job has been submitted with JobID 7aa32f4db327b5319f9ec08c03284426";


        Matcher matcher = FLINK_ID_REGEX.matcher(s);
        System.out.println(matcher.find());
        System.out.println(matcher.group().toString());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
    }
}
