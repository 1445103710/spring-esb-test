package com.yao.springbootvalid.classload;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/01 15:22
 * @Description:
 * @see com.yao.springbootvalid.classload
 */
public class MyClassLoader {

    private final static ConcurrentHashMap<String,MyURLClassLoader> LOADER_CACHE = new ConcurrentHashMap<>();


        public void loadJar(String jarName) throws MalformedURLException{
            MyURLClassLoader urlClassLoader = LOADER_CACHE.get(jarName);
            if(urlClassLoader!=null){
                return;
            }
            urlClassLoader = new MyURLClassLoader();
//        String path = systemConfig.getExternalClassPath();
            //String path = "E:/testspace/externalClassPath";
            //URL jarUrl = new URL("jar:file:/"+path+"/"+jarName+"!/");
            URL jarUrl = new URL("jar:file:/"+jarName+"!/");
            urlClassLoader.addURLFile(jarUrl);
            LOADER_CACHE.put(jarName,urlClassLoader);
        }


    public Class loadClass(String jarName,String name) throws ClassNotFoundException {
        MyURLClassLoader urlClassLoader = LOADER_CACHE.get(jarName);
        if(urlClassLoader==null){
            return null;
        }
        return urlClassLoader.loadClass(name);
    }

    public void unloadJarFile(String jarName) throws MalformedURLException {
        MyURLClassLoader urlClassLoader = LOADER_CACHE.get(jarName);
        if(urlClassLoader==null){
            return;
        }
//        String path = systemConfig.getExternalClassPath();
        String path = "E:/testspace/externalClassPath";
        String jarStr = "jar:file:/"+path+"/"+jarName+"!/";
        urlClassLoader.unloadJarFile(jarStr);
        urlClassLoader = null;
        LOADER_CACHE.remove(jarName);
    }
}
