package com.yao.springboottest.json.controller.strategy.json;


/**
 * @ClassName AbstractPluginHandler
 * @Description 插件抽象处理类
 * @Author zhoubang
 * @Date 2019/5/6 11:42
 */
public abstract class AbstractJSONHandler<T> {
    /**
     * 处理json操作
     */
    public String handleAdd(final T t) {
        return null;
    }

}
