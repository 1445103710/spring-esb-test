package com.yao.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.yao.handle.ability.ParseAbilityList;
import com.yao.handle.postman.PostmanCollection;
import com.yao.service.FileService;
import com.yao.util.MultipartFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className FileServiceImpl
 * @description: 解析文件中参数
 * @author: yaoyao
 * @create: 2020/03/02 22:23
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(String name, MultipartFile file) {
        String multipartFileContent = MultipartFileUtil.getMultipartFileContent(file);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ParseAbilityList parseAbilityList = new ParseAbilityList();
            PostmanCollection postmanCollection = objectMapper.readValue(multipartFileContent, PostmanCollection.class);
            parseAbilityList.parsePostmanCollection(postmanCollection);
            String s = objectMapper.writeValueAsString(postmanCollection);
            String s1 = objectMapper.writeValueAsString(parseAbilityList.getAbilityList());
            System.out.println(s);
            System.out.println(s1);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return multipartFileContent;
    }
}
