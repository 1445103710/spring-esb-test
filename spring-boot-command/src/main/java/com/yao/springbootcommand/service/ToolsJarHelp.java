package com.yao.springbootcommand.service;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/09 12:37
 * @Description:
 * @see com.yao.springbootcommand.service
 */
@Slf4j
public class ToolsJarHelp {
    public static void cmd1(String cwds,String path) throws RuntimeException {
        log.info("执行命令1");
        ByteArrayOutputStream stderr = new ByteArrayOutputStream();
        ExecuteWatchdog watchdog = new ExecuteWatchdog(100);

        DefaultExecutor executor = new DefaultExecutor();
        executor.setWorkingDirectory(new File(path));
        executor.setStreamHandler(new PumpStreamHandler(null, stderr, null));
        executor.setWatchdog(watchdog);

        CommandLine cmd = new CommandLine(cwds);
        log.info("Compiler cmd:\t" + cmd.toString());

        try {
            executor.execute(cmd);
            log.info("cmd OK");
        } catch (IOException e) {
            if (watchdog.killedProcess()) {
                log.warn("cmd Time Exceeded:\t" + e.getMessage());
            } else {
                log.warn("cmd error:\t" + e.getMessage());
            }
            e.printStackTrace();
            log.warn(stderr.toString());
            throw new RuntimeException("cmd Aborted.");
        }
    }
    public static void cmd2(String cwds) {
        log.info("执行命令2");
        String command = cwds;

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedInputStream bis = new BufferedInputStream(
                    process.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(bis));
            String line;
            log.info("执行命令"+command);
            while ((line = br.readLine()) != null) {
                log.info(line);
            }

            process.waitFor();
            if (process.exitValue() != 0) {
                log.info("error!");
            }

            bis.close();
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void cmd3(String jarPath,String classPath,String workDir) throws RuntimeException {
        CommandLine cmd = new CommandLine("jar");
        cmd.addArgument("-cf");
        cmd.addArgument(jarPath);
        cmd.addArgument(classPath);
        log.info(cmd.toString());

        ByteArrayOutputStream stderr = new ByteArrayOutputStream();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setWorkingDirectory(new File(workDir));
        executor.setStreamHandler(new PumpStreamHandler(null, stderr, null));
        try {
            executor.execute(cmd);
            if (stderr.toString().length() > 0) {
                throw new RuntimeException("Sandbox Aborted."+stderr.toString());
            }
            log.info("class to jar OK");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("class to jar error:\t" + e.getMessage());
            throw new RuntimeException("An Error Occurred.");
        }
    }
    /**
     * 执行不需要返回结果的命令
     * @throws Exception
     */
    public static void execCmdWithoutResult(String jarPath,String classPath,String workDir) throws Exception{
        //开启windows telnet: net start telnet
        //注意：第一个空格之后的所有参数都为参数
        CommandLine cmdLine = new CommandLine("jar");
        cmdLine.addArgument("-cf");
        cmdLine.addArgument(jarPath);
        cmdLine.addArgument(classPath);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        //设置60秒超时，执行超过60秒后会直接终止
        ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000*10);
        executor.setWatchdog(watchdog);
        executor.setWorkingDirectory(new File(workDir));
        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        executor.execute(cmdLine, handler);
        //命令执行返回前一直阻塞
        handler.waitFor();
    }

    /**
     * 带返回结果的命令执行
     * @return
     */
    public static String execCmdWithResult(String command,String workDir,String bm) {
        try {
            //接收正常结果流
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //接收异常结果流
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
            CommandLine commandline = CommandLine.parse(command);
            DefaultExecutor exec = new DefaultExecutor();
            exec.setExitValues(null);
            exec.setWorkingDirectory(new File(workDir));
            //设置一分钟超时
            ExecuteWatchdog watchdog = new ExecuteWatchdog(60*1000);
            exec.setWatchdog(watchdog);
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream,errorStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(commandline);
            //不同操作系统注意编码，否则结果乱码
            String out = outputStream.toString(bm);
            String error = errorStream.toString(bm);
            return out+"||||||||||||||||||||||||||"+error;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
