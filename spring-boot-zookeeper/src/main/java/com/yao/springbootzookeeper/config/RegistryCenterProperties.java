package com.yao.springbootzookeeper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

import lombok.Data;

/**
 * @ClassName: RegistryCenterProperties
 * @Description: zk配置信息
 * @Date: 2019/3/28 10:45
 * @Author fuchangmin
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.zookeeper")
public class RegistryCenterProperties implements Serializable {

    private String zkAddressList;
    /** 配置父节点 */
    private String namespace;
    /** 监控节点 */
    private String listenerNode ;
    /** 维护节点 */
    private String nodeInfo;

}
