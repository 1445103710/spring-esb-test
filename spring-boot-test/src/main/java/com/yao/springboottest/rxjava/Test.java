package com.yao.springboottest.rxjava;


import io.reactivex.Observable;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/23 12:22
 * @Description:
 * @see com.yao.springboottest.rxjava
 */
public class Test {

    public static void main(String[] args) {
        Observable.just(1,2,3).subscribe(System.out::println);
    }
}
