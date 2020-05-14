package com.yao.springbootexcel.controller;

import com.yao.springbootexcel.config.AliyunOSSConfig;
import com.yao.springbootexcel.util.ExcelUtil;
import com.yao.springbootexcel.util.OSSBootUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @className AnalysisExcel
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/07 20:18
 */
@Slf4j
@RestController
@RequestMapping("/excel")
public class AnalysisExcel {
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
    ExecutorService fixedThreadPool =Executors.newCachedThreadPool(new BasicThreadFactory.Builder().namingPattern("task-schedule-pool-%d").daemon(true).build());

    @PostMapping("/upload")
    public Map uploadCourseExcel(@RequestParam("file") MultipartFile file, @RequestParam(value = "names", required = false) String names) {
        Map map = new HashMap<>(16);

        try {
            InputStream inputStream = file.getInputStream();
            long size = file.getSize();
            Workbook workbook = ExcelUtil.getWorkbook(1, inputStream);
            Sheet sheet1 = workbook.getSheet("人员信息");
            if (StringUtils.isEmpty(names)) {
                names = "人员信息,人员信息+发展人编码,人员信息+工号";
            }
            List<String> strings = Arrays.asList(names.split(","));
//            Sheet sheet2 = workbook.getSheet("人员信息+发展人编码");
//            Sheet sheet3 = workbook.getSheet("人员信息+工号");
            Set<String> set = new HashSet<>();
            System.out.println(sheet1.getSheetName());
//            System.out.println(sheet2.getSheetName());
//            System.out.println(sheet3.getSheetName());

            int lastRowNum1 = sheet1.getLastRowNum();
//            int lastRowNum2 = sheet2.getLastRowNum();
//            int lastRowNum3 = sheet3.getLastRowNum();

            for (int i = 1; i <= lastRowNum1; i++) {
                String name = sheet1.getRow(i).getCell(4).getStringCellValue();
                set.add(name);
            }
            set.forEach((a) -> {
                fixedThreadPool.submit(() -> {
                    Workbook wb = new XSSFWorkbook();
                    for (String n : strings) {
                        Sheet sheet = wb.createSheet(n);
                        Sheet sheetx = workbook.getSheet(n);

                        Row row = sheetx.getRow(0);

                        short lastCellNum = row.getLastCellNum();
                        int lastRowNum = sheetx.getLastRowNum();
                        log.info(Thread.currentThread().getName() + "[" + a + "]");
                        int z = 0;
                        ExcelUtil.copyRows(sheetx, sheet, z, z);
                        sheet.createFreezePane( 0, 1, 0, 1 );
                        z++;
                        for (int i = 0; i < lastCellNum; i++) {
                            if ("大区/县分".equals(row.getCell(i).getStringCellValue())) {
                                for (int j = 1; j <= lastRowNum; j++) {
                                    if (a.equals(sheetx.getRow(j).getCell(i).getStringCellValue())) {
                                        ExcelUtil.copyRows(sheetx, sheet, j, z);
                                        z++;
                                    }
                                }
                            }
                        }
                        sheet.autoSizeColumn(1);
                    }
                    try {

                        String fileName = "各单元人员信息及对应发展人编码&工号(" + a + ").xlsx";
//                        fileOutputStreamx = new FileOutputStream();
//                        wb.write(fileOutputStreamx);
//                        fileOutputStreamx.flush();
//                        fileOutputStreamx.close();
                        final ByteArrayOutputStream outputStreamx = new ByteArrayOutputStream();
                        wb.write(outputStreamx);
                        final ByteArrayInputStream inputStreamx = new ByteArrayInputStream(outputStreamx.toByteArray());
                        String upload = OSSBootUtil.upload(aliyunOSSConfig, inputStreamx, "nana",fileName);
                        map.put(fileName,upload);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    log.info(Thread.currentThread().getName() + "[" + a + "],结束了！！！");

                });
//                Thread thread = new Thread(() -> {});
//                thread.start();
            });


//            FileOutputStream fileOutputStreamx = null;
//
//            fileOutputStreamx = new FileOutputStream("/Users/yaoyao/Desktop/娜娜/各单元人员信息及对应发展人编码&工号（" + k + "）.xlsx");
//            workbookx.write(fileOutputStreamx);
//            fileOutputStreamx.flush();
//            fileOutputStreamx.close();

            map.put("code", "0");
            map.put("msg", "操作成功");
            map.put("fileName", size);
            return map;
        } catch (Exception e) {
            map.put("code", "1");
            map.put("msg", "操作失误");
            return map;
        } finally {

        }
    }
}
