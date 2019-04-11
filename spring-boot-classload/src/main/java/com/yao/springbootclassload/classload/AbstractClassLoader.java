package com.yao.springbootclassload.classload;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/04/11 11:23
 * @Description:
 * @see com.yao.springbootclassload.classload
 */
public class AbstractClassLoader extends URLClassLoader{


    public AbstractClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public AbstractClassLoader(URL[] urls) {
        super(urls);
    }

    public AbstractClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
