package com.yao.springboottest.java8.con;

import lombok.Data;

/**
 * @className Employee
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/07/02 15:19
 */
@Data
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
