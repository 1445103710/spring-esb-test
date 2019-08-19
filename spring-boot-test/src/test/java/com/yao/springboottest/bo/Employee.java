package com.yao.springboottest.bo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className Employee
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/05/20 22:32
 */
@Data
@AllArgsConstructor
public class Employee {

    private String name;

    private int age;

    private Double salary;

}
