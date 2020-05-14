package com.yao.springbootexcel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @className AliyunOSSConfig
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/05/08 22:17
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
/**
 * 阿里云oss的配置类
 */
@Data
public class AliyunOSSConfig {
    private String bucketName;
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String url;
}
