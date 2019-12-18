package com.yao.springboottest.json.controller.strategy.json;

import com.google.common.collect.Maps;
import com.yao.springboottest.util.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @ClassName HandlerProcessor
 * @Description 扫描@PluginTypeHandlerType，初始化HandlerContext，将其注册到spring容器
 * @Author zhoubang
 * @Date 2019/5/6 15:14
 */
@Component
public class JSONHandlerProcessor implements BeanFactoryPostProcessor {

    private static final String JSON_HANDLER_PACKAGE = "com.yao";

    /**
     * 扫描@PluginTypeHandlerType，初始化HandlerContext，将其注册到spring容器
     *
     * @param beanFactory bean工厂
     * @see AbilityJSONHandlerType
     * @see JSONHandlerContext
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMap = Maps.newHashMap();
        //获取插件
        ClassScaner.scan(JSON_HANDLER_PACKAGE, AbilityJSONHandlerType.class).forEach(clazz -> {
            // 获取注解中的类型值
            String type = clazz.getAnnotation(AbilityJSONHandlerType.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存map中
            handlerMap.put(type, clazz);
        });
        // 初始化handlercontext，将其注册到spring容器中
        JSONHandlerContext handlerContext = new JSONHandlerContext(handlerMap);
        beanFactory.registerSingleton(JSONHandlerContext.class.getName(), handlerContext);
    }
}
