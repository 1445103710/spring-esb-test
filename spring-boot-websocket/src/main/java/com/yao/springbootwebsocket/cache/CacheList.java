package com.yao.springbootwebsocket.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @className CacheList
 * @description: TODO
 * @author: yaoyao
 * @create: 2020/09/15 20:11
 */
public class CacheList {

    private static List<String> list = new ArrayList();


    public static void setCache(String s){
        list.add(s);
    }

    public static List getAllCache(){
        return list;
    }

    public static void clearCache(){
        list.clear();
    }
    public static int getCacheSize(){
        return list.size();
    }
}
