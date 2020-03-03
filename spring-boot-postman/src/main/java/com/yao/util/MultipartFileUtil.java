package com.yao.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @className MultipartFileUtil
 * @description: 获取MultipartFile文件
 * @author: yaoyao
 * @create: 2020/03/02 21:13
 */
@Slf4j
public class MultipartFileUtil {
    /**
     * 读取MultipartFile内容
     *
     * @return
     */
    public static String getMultipartFileContent(MultipartFile multipartFile) {
        Reader reader = null;
        try {
            reader = new InputStreamReader(multipartFile.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                if (line != null && line != "") {
                    stringBuffer.append(line);
                }
            }
            reader.close();
            return stringBuffer.toString();
        } catch (IOException e) {
            log.error("读取数据异常。。。" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
