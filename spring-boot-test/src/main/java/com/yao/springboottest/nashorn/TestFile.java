package com.yao.springboottest.nashorn;

import com.alibaba.fastjson.JSONObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @className TestFile
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/02/12 10:45
 */
public class TestFile {
    public static void main(String[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            FileReader scriptFile = new FileReader("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-test/src/main/java/com/yao/springboottest/nashorn/nashornJs.js");
            engine.eval(scriptFile);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
