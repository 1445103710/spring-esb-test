package com.yao.springboottest.json.controller.strategy.json;

import com.yao.springboottest.exception.CustomException;
import com.yao.springboottest.util.BeanTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * @ClassName JSONHandlerContext
 * @Description 定义环境角色（Context）：用于连接上下文
 * @Author zhoubang
 * @Date 2019/5/6 14:18
 */
public class JSONHandlerContext {

    private static Logger logger = LogManager.getLogger(JSONHandlerContext.class);

    private Map<String, Class> handlerMap;

    public JSONHandlerContext(Map<String, Class> map) {
        this.handlerMap = map;
    }

    public AbstractJSONHandler getJSONInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new CustomException(00,"没有找到此落地协议处理类型：" + type);
        }
        return (AbstractJSONHandler) BeanTool.getBean(clazz);
    }
}
