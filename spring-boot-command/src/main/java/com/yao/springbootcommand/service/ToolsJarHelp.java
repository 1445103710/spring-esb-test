package com.yao.springbootcommand.service;

import org.apache.commons.exec.CommandLine;
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

}
