package com.yao.handle.rocketmq;

import lombok.Data;

import java.io.Serializable;

/**
 * @className MyMessage
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/12 16:24
 */
@Data
public class MyMessage<T> implements Serializable {
    private String id;
    private T content;
}
