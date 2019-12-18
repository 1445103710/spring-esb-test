package com.yao.springbootwebserviceclient.util.wsdl;

import com.google.common.collect.Lists;
import org.apache.cxf.tools.common.ToolContext;
import org.apache.cxf.tools.wsdlto.WSDLToJava;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @className WSDLCommand
 * @description: 用于执行commad命令
 * @author: yaoyao
 * @create: 2019/10/30 11:12
 * wsdl2java - takes a WSDL document and generates fully annotated Java code from which to implement a service.
 * Usage : wsdl2java -fe|-frontend <front-end-name> -db|-databinding <data-binding-name>
 * -wv <wsdl-version> -p <[wsdl-namespace =]package-name>* -sn <service-name>
 * -b <binding-file-name>* -reserveClass <class-name>* -catalog <catalog-file-name>
 * -d <output-directory> -compile -classdir <compile-classes-directory> -impl -server
 * -client -clientjar <jar-file-name> -all -autoNameResolution -allowElementReferences|-aer<=true>
 * -defaultValues<=class-name-for-DefaultValueProvider> -ant
 * -nexclude <schema-namespace [= java-package-name]>* -exsh <(true, false)> -noTypes
 * -dns <(true, false> -dex <(true, false)> -validate -keep
 * -wsdlLocation <wsdlLocation> -xjc<xjc-arguments>* -asyncMethods<[=method1,method2,...]>*
 * -bareMethods<[=method1,method2,...]>* -mimeMethods<[=method1,method2,...]>* -noAddressBinding
 * -faultSerialVersionUID <fault-serialVersionUID> -exceptionSuper <exceptionSuper>
 * -mark-generated -suppress-generated-date -maxExtensionStackDepth <maxExtensionStackDepth>
 * -h|-?|-help -version|-v -verbose|-V -quiet|-q|-Q
 * -wsdlList <wsdlurl>
 * "-compile", "-d", "/java", "-client", "-clientjar","yaoyao.jar","-validate","-classdir",
 * "/classes", "-p", "org.cxf","http://localhost:8081/yaoyao/CommonService?wsdl"
 */
public class WSDLCommand {
    /**
     * 构建wsdl转化java
     * @param wsdlParams
     * @throws Exception
     */
    public static void wsdl2java(WSDLParams wsdlParams) throws Exception {
        ArrayList<String> command = Lists.newArrayList();
        command.add("-compile");
        command.add("-d");
        command.add(wsdlParams.getJavaPath());
        command.add("-client");
        command.add("-clientjar");
        command.add(wsdlParams.getJarPath());
        command.add("-validate");
        command.add("-classdir");
        command.add(wsdlParams.getClassPath());
        command.add("-p");
        command.add(wsdlParams.getPackgeName());
        command.add(wsdlParams.getWsdlUrl());
        Object[] objCommand = command.toArray();
        String[] commands = Arrays.copyOf(objCommand, objCommand.length, String[].class);
        new WSDLToJava(commands).run(new ToolContext());
    }
}
