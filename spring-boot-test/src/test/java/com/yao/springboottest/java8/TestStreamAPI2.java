package com.yao.springboottest.java8;

import com.yao.springboottest.bo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @className TestStreamAPI2
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/05/20 22:30
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 12, 9999.99),
            new Employee("李四", 132, 9799.99),
            new Employee("王二", 22, 8999.99),
            new Employee("麻子", 42, 9939.99),
            new Employee("麻子", 42, 9939.99)

    );

    @Test
    public void test1() {
        Stream<Employee> employeeStream = employees.stream().filter((e) -> {
            System.out.println("执行中间操作");
            return e.getAge() > 13;
        });

        employeeStream.forEach(System.out::println);
    }

    /**
     * 外部迭代
     */
    @Test
    public void test2() {
        employees.stream()
                .filter((e) -> e.getAge() > 13)
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream()
                .filter((e -> e.getAge() > 13))
                .skip(2)
                .forEach(System.out::println);
    }


    @Test
    public void test4() {
        employees.stream()
                .filter((e -> e.getAge() > 13))
                .distinct()
                .forEach(System.out::println);
    }




    @Test
    public void test5() {
        List<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        Optional<String> reduce = list.stream().reduce((i, a) -> i.concat(",").concat(a));
        System.out.println(reduce.isPresent());
        System.out.println(reduce.get());

    }


    @Test
    public void test6() {
        List<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);

    }
}
