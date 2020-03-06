package com.yao.handle.channel;

import com.yao.handle.channel.impl.GenerateSchemaFromRawServiceImpl;
import com.yao.handle.channel.impl.GenerateSchemaFromUnknownServiceImpl;
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
public class FactoryForSchema {

    static Map<String, GenerateSchemaService> strategys = new ConcurrentHashMap<>(2);
    //如果加入特殊接入协议请列举处理。目前返回报文包含了请求协议
    static {
        strategys.put(GenetateSchemaEnum.RAW.getCode(),new GenerateSchemaFromRawServiceImpl());
        strategys.put(GenetateSchemaEnum.EMPTY.getCode(), new GenerateSchemaFromUnknownServiceImpl());
        strategys.put(GenetateSchemaEnum.FILE.getCode(), new GenerateSchemaFromUnknownServiceImpl());
        strategys.put(GenetateSchemaEnum.FORM_DATA.getCode(), new GenerateSchemaFromUnknownServiceImpl());
        strategys.put(GenetateSchemaEnum.URL_ENCODED.getCode(), new GenerateSchemaFromUnknownServiceImpl());
    }
    public static GenerateSchemaService getStrategy(String code) {
        GenerateSchemaService strategy = strategys.get(code);
        if (strategy == null) {
            return new GenerateSchemaFromUnknownServiceImpl();
        }
        return strategy;
    }
}
