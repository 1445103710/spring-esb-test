package com.yao.springbootwebserviceclient.test;

import com.yao.springbootwebserviceclient.util.wsdl.WSDLCommand;
import com.yao.springbootwebserviceclient.util.wsdl.WSDLParams;
import org.apache.cxf.tools.common.ToolContext;
import org.apache.cxf.tools.wsdlto.WSDLToJava;
import org.junit.jupiter.api.Test;

/**
 * @className TestCxfWsdl
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/10/29 16:13
 */
public class TestCxfWsdl {

    @Test
    public void wsdl2java() throws Exception {
        String[] args = new String[] {"-compile", "-d", "/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-webservice-client/src/main/class", "-client", "-clientjar","yaoyao.jar","-dns","false","-autoNameResolution","-validate","-classdir",
                "/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-webservice-client/src/main/class" + "/class", "-p", "org.cxf","http://localhost:8081/yaoyao/CommonService?wsdl"};
        new WSDLToJava(args).run(new ToolContext());
    }

    @Test
    public void wsdl2javaFile() throws Exception {
        String[] args = new String[] {"-compile", "-d", "/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-webservice-client/src/main/java", "-classdir",
                "/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-webservice-client/src/main/java" + "/classes", "-p", "org.yaoyao","/Users/yaoyao/local/work/ability/UsrSer/META-INF/UsrSer.wsdl"};
        new WSDLToJava(args).run(new ToolContext());
    }


    @Test
    public void wsdl2javaUtil() throws Exception {
        WSDLParams build = WSDLParams.builder()
                .javaPath("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-webservice-client/src/main/ws/java")
                .classPath("/Users/yaoyao/IdeaProjects/practise/spring-esb-test/spring-boot-webservice-client/src/main/ws/class")
                .jarPath("xxx.jar")
                .packgeName("com.xmdj")
                .wsdlUrl("http://localhost:8081/yaoyao/CommonService?wsdl")
                .build();
        WSDLCommand.wsdl2java(build);
    }
}
