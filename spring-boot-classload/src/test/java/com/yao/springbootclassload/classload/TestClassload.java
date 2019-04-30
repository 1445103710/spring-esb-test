package com.yao.springbootclassload.classload;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/12 9:29
 * @Description:
 * @see com.yao.springbootclassload.classload
 */
public class TestClassload {
    @Test
    public void TestDy() throws MalformedURLException, ClassNotFoundException {
        File file  = new File("F:\\java\\interlliJIDE\\tydic\\nlpt\\ability\\svcservice\\jar\\test_ability_1_1_req.jar");
        DynamicJarClassLoader dynamicJarClassLoader = new DynamicJarClassLoader(new URL[]{file.toURI().toURL()});
        System.out.println(dynamicJarClassLoader.loadClass("test_ability_1_req.Root"));
        Class<?> aClass = dynamicJarClassLoader.loadClass("test_ability_1_req.Root");
        System.out.println(Arrays.asList(aClass.getAnnotations()));
    }
}
