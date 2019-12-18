package com.yao.springbootwebserviceclient.util.wsdl;

import lombok.Builder;
import lombok.Data;

/**
 * @className WSDLParams
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/10/30 14:15
 * String javaPath,String classPath,String jarPath,String packgeName,String wsdlUrl
 */
@Data
@Builder
public class WSDLParams {
    private final String javaPath;
    private final String classPath;
    private final String jarPath;
    private final String packgeName;
    private final String wsdlUrl;
}
