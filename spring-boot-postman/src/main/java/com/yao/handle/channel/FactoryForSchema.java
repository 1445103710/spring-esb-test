package com.yao.handle.channel;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className FactoryForWebClient
 * @description: 对于报文转化的工厂方法
 * @author: yaoyao
 * @create: 2020/01/08 15:04
 */
@Service
public class FactoryForSchema {
    @Resource
    Map<String, GenerateSchemaService> strategys = new ConcurrentHashMap<>(2);

    @Resource(name = "generateSchemaFromUnknown")
    private GenerateSchemaService generateSchemaService;

    public GenerateSchemaService getStrategy(String code) {
        GenerateSchemaService strategy = strategys.get(GenetateSchemaEnum.getServiceName(code));
        if (strategy == null) {
            return generateSchemaService;
        }
        return strategy;
    }
}
