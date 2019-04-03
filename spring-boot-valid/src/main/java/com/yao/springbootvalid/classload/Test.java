package com.yao.springbootvalid.classload;

import java.net.MalformedURLException;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/01 15:23
 * @Description:
 * @see com.yao.springbootvalid.classload
 */
public class Test {
    public static void main(String[] args) {

        MyClassLoader classLoader = new MyClassLoader();
//        while (true)
            try {
            classLoader.loadJar("F:/java/interlliJIDE/tydic/nlpt/ability/svcservice/test_ability_v1/req_hello_1_2.jar");
            Class clz = classLoader.loadClass("F:/java/interlliJIDE/tydic/nlpt/ability/svcservice/test_ability_v1/req_hello_1_2.jar", "java.interlliJIDE.tydic.nlpt.ability.svcservice.javac.hello.hello_1.Body");
            System.out.println(clz);
            Thread.sleep(1000);
            classLoader.unloadJarFile("req_hello_1_2.jar");
//                System.gc();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
