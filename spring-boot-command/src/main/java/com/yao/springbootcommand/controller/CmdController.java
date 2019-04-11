package com.yao.springbootcommand.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.springbootcommand.service.ToolsJarHelp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/09 12:47
 * @Description:
 * @see com.yao.springbootcommand.controller
 */
@RestController
@RequestMapping("cmd")
@Slf4j
public class CmdController {
    @RequestMapping("cmd1")
    public Map cmd1(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String cmd = jsonObject.getString("cmd");
        String path = jsonObject.getString("path");
        Map result = new HashMap(16);
        try {
            ToolsJarHelp.cmd1(cmd,path);
            result.put("code","0000");
            result.put("desc","执行成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("cmd2")
    public Map cmd2(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String cmd = jsonObject.getString("cmd");
        Map result = new HashMap(16);
        try {
            ToolsJarHelp.cmd2(cmd);
            result.put("code","0000");
            result.put("desc","执行成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("cmd3")
    public Map cmd3(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String jarPath = jsonObject.getString("jarPath");
        String classPath = jsonObject.getString("classPath");
        String workDir = jsonObject.getString("workDir");
        Map result = new HashMap(16);
        try {
            ToolsJarHelp.cmd3(jarPath,classPath,workDir);
            result.put("code","0000");
            result.put("desc","执行成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("cmd4")
    public Map cmd4(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String jarPath = jsonObject.getString("jarPath");
        String classPath = jsonObject.getString("classPath");
        String workDir = jsonObject.getString("workDir");
        Map result = new HashMap(16);
        try {
            ToolsJarHelp.execCmdWithoutResult(jarPath,classPath,workDir);
            result.put("code","0000");
            result.put("desc","执行成功");
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("cmd5")
    public Map cmd5(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String workDir = jsonObject.getString("workDir");
        String cmd = jsonObject.getString("cmd");
        String bm = jsonObject.getString("bm");
        Map result = new HashMap(16);
        try {
            String s = ToolsJarHelp.execCmdWithResult(cmd,workDir,bm);
            result.put("code","0000");
            result.put("desc","执行成功");
            result.put("data",s);
        } catch (Exception e) {
            result.put("code","9999");
            result.put("desc",e.toString());
            e.printStackTrace();
        }
        return result;
    }
}
