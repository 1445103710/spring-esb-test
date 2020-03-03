package com.yao.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @className FileService
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/03/02 20:51
 */
public interface FileService {
    public String upload(String name, MultipartFile file);
}
