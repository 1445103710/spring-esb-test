package com.yao.springbootzookeeper.service;
import com.alibaba.fastjson.JSON;
import com.yao.springbootzookeeper.config.RegistryCenterProperties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/04 10:17
 * @Description:
 * @see com.yao.springbootzookeeper.service
 */
@Configuration
public class DataWatcher {

    private static final Log log = LogFactory.getLog(DataWatcher.class);

    @Resource
    private CuratorFramework zkClient;
    @Resource
    private RegistryCenterProperties registryCenterProperties;


    /**
     * 监听子节点的变化情况
     * @return
     * @throws Exception
     */
    @Bean
    public PathChildrenCache dataWatcherListenable() throws Exception {
        final PathChildrenCache childrenCache = new PathChildrenCache(zkClient, registryCenterProperties.getListenerNode() +"/"+ "ceshi", true);
        log.info("监听节点:"+registryCenterProperties.getListenerNode() +"/"+ "ceshi");
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        childrenCache.getListenable().addListener(
                (client, event) -> {
                    switch (event.getType()) {
                        case CHILD_ADDED:
                            log.info("CHILD_ADDED: {}, DATA: {}"+" "+event.getData().getPath()+" "+new String(event.getData().getData()));
                            break;
                        case CHILD_REMOVED:
                            log.info("CHILD_REMOVED: {}"+" "+event.getData().getPath());
                            break;
                        case CHILD_UPDATED:
                            log.info("CHILD_UPDATE: {}"+" "+event.getData().getPath()+"数据:"+new String(event.getData().getData()));
                            log.info(JSON.toJSONString(event.getData()));
                            System.out.println(event.getData().getPath().replaceAll(registryCenterProperties.getListenerNode()+"/ceshi",""));
                            break;
                        default:
                            break;
                    }
                }
        );
        return childrenCache;
    }


}

