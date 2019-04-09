package com.yao.springbootcommand;

import org.junit.Test;

import lombok.Data;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/09 14:23
 * @Description:
 * @see com.yao.springbootcommand
 */
public class TestYao {
    @Test
    public void test(){
        Yao yao = new Yao();
        ja(yao);
        System.out.println(yao.toString());
    }

    public static void ja(Yao yao){
        yao.setName("111");
    }

    @Data
    public class Yao{
        String name;

    }
}
