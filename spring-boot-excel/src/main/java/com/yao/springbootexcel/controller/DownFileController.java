package com.yao.springbootexcel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @className AnalysisExcel
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/07 20:18
 */
@Slf4j
@RestController
@RequestMapping("/jpg")
public class DownFileController {
    /**
     * 通过excel文件，批量增加课程
     *
     * @param file
     * @return
     * @throws Exception
     */
//    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(20,
//            new BasicThreadFactory.Builder().namingPattern("task-schedule-pool-%d").daemon(true).build());
//    ExecutorService fixedThreadPool =Executors.newCachedThreadPool(new BasicThreadFactory.Builder().namingPattern("task-schedule-pool-%d").daemon(true).build());
    @PostMapping("/upload")
    public Map uploadCourseExcel(@RequestParam("businessChangeFile") MultipartFile file,@RequestParam("taxpayerCertificateFile") MultipartFile file2, @RequestParam(value = "unitName", required = false) String unitName) {
        Map map = new HashMap<>(16);

        System.out.println(unitName);
        approvalFile(file);
        approvalFile2(file2);
        map.put("1", "222");
        return map;
    }

    public void approvalFile(MultipartFile filecontent) {
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        try {
            inputStream = filecontent.getInputStream();
            fileName = filecontent.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String path = "file";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void approvalFile2(MultipartFile filecontent) {
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        try {
            inputStream = filecontent.getInputStream();
            fileName = filecontent.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String path = "file2";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
