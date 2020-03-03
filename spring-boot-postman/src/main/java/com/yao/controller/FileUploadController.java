package com.yao.controller;

import com.yao.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @className FileUploadController
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/02 20:50
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Resource
    FileService fileService;

    @PostMapping("/upload")
    public String upload(String name, MultipartFile file) {
        return fileService.upload(name, file);
    }

}
