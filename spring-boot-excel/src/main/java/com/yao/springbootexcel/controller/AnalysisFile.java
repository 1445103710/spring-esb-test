package com.yao.springbootexcel.controller;

import com.yao.springbootexcel.config.AliyunOSSConfig;
import com.yao.springbootexcel.util.OSSBootUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className AnalysisExcel
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/07 20:18
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class AnalysisFile {
    @Resource
    private AliyunOSSConfig aliyunOSSConfig;
    /**
     * 通过excel文件，批量增加课程
     *
     * @param file
     * @return
     * @throws Exception
     */
//    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(20,
//            new BasicThreadFactory.Builder().namingPattern("task-schedule-pool-%d").daemon(true).build());
    ExecutorService fixedThreadPool = Executors.newCachedThreadPool(new BasicThreadFactory.Builder().namingPattern("task-schedule-pool-%d").daemon(true).build());

    @PostMapping("/upload")
    public Map uploadCourseExcel(@RequestParam("file") MultipartFile file, @RequestParam(value = "names", required = false) String names) {
        Map map = new HashMap<>(16);


        try {
            String ceshi = OSSBootUtil.upload(aliyunOSSConfig, file.getInputStream(), "timing", file.getName());
//            FileOutputStream fileOutputStreamx = null;
//
//            fileOutputStreamx = new FileOutputStream("/Users/yaoyao/Desktop/娜娜/各单元人员信息及对应发展人编码&工号（" + k + "）.xlsx");
//            workbookx.write(fileOutputStreamx);
//            fileOutputStreamx.flush();
//            fileOutputStreamx.close();

            map.put("code", "0");
            map.put("msg", "操作成功");
            map.put("file", ceshi);
            return map;
        } catch (Exception e) {
            map.put("code", "1");
            map.put("msg", "操作失误");
            return map;
        } finally {

        }
    }
}
