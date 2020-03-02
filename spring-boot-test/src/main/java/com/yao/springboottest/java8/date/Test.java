package com.yao.springboottest.java8.date;

import java.sql.SQLOutput;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @className Test
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/11 21:03
 */
public class Test {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        /**
         * Java 8 中的 LocalDate 用于表示当天日期。和java.util.Date
         * 不同，它只有日期，不包含时间。当你仅需要表示日期时就用这个类。
         * 2020-02-11
         */
        System.out.println(localDate);

        int year = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        int dayOfMonth = localDate.getDayOfMonth();
        /**
         * year:2020
         * month:2
         * day:11
         */
        System.out.println("year:"+year);
        System.out.println("month:"+monthValue);
        System.out.println("day:"+dayOfMonth);

        /**
         * 我们通过静态工厂方法now()非常容易地创建了当天日期，你还可以调用另一个
         * 有用的工厂方法LocalDate.of()创建任意日期， 该方法需要传入年、月、日
         * 做参数，返回对应的LocalDate实例。这个方法的好处是没再犯老API的设计错
         * 误，比如年度起始于1900，月份是从0开 始等等。
         * 2019-02-12
         */
        LocalDate of = LocalDate.of(2019, 2, 12);
        System.out.println(of);

        /**
         * 可以equals判断时间可相等
         * 时间不等
         */
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018,2,5);
        if(date1.equals(date2)){
            System.out.println("时间相等");
        }else{
            System.out.println("时间不等");
        }

        /**
         * 判断周期性生日
         * 生日到了
         */
        LocalDate date3 = LocalDate.now();
        LocalDate of1 = LocalDate.of(1994, 2, 11);
        MonthDay of2 = MonthDay.of(of1.getMonth(), of1.getDayOfMonth());
        MonthDay of3 = MonthDay.of(date3.getMonth(), date3.getDayOfMonth());
        if (of2.equals(of3)){
            System.out.println("生日到了");
        }else {
            System.out.println("生日没到");
        }

        /**
         * 获取当前时间，不含有日期
         * 21:29:40.557
         */
        LocalTime now = LocalTime.now();
        System.out.println(now);

        /**
         * 和上个例子计算3小时以后的时间类似，这个例子会计算一周后的日期。
         * LocalDate日期不包含时间信息，它的plus()方法用来增加天、周、月，
         * ChronoUnit类声明了这些时间单位。由于LocalDate也是不变类型，
         * 返回后一定要用变量赋值。
         * 当前时间:2020-02-11
         * 一周后时间:2020-02-18
         */
        LocalDate now1 = LocalDate.now();
        System.out.println("当前时间:"+now1);
        LocalDate plus = now1.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后时间:"+plus);

        /**
         * 利用minus()方法计算一年前的日期
         * 一年前的日期:2019-02-11
         * 一年后的日期:2021-02-11
         */
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期:" + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期:"+nextYear);

        /**
         * Java 8增加了一个Clock时钟类用于获取当时的时间戳，
         * 或当前时区下的日期时间信息。以前用到System.currentTimeInMillis()
         * 和TimeZone.getDefault()的地方都可用Clock替换。
         * Clock : 1581428520274
         * Clock : 1581428520274
         */
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());
        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());

        /**
         * 另一个工作中常见的操作就是如何判断给定的一个日期是大于某天
         * 还是小于某天？在Java 8中，LocalDate类有两类方法isBefore()和isAfter()
         * 用于比较日期。调用isBefore()方法时，如果给定日期小于当前日期则返回true。
         * true
         * false
         */
        LocalDate now2 = LocalDate.now();
        LocalDate of4 = LocalDate.of(2019, 12, 21);
        System.out.println(now2.isAfter(of4));
        System.out.println(now2.isBefore(of4));

        /**
         *
         */
    }
}
