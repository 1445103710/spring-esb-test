package com.yao.springbootwebserviceclient.util.wsdl;

import com.ibm.wsdl.BindingImpl;
import com.ibm.wsdl.PortTypeImpl;
import com.ibm.wsdl.xml.WSDLReaderImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.wsdl.*;
import javax.wsdl.xml.WSDLReader;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @className WsdlUtil
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/10/28 11:47
 */
public class WsdlUtil {
    /**
     * 参考SoapMessageBuilder.SoapMessageBuilder(URL wsdlUrl)方法
     * 获取portType中的所有operation
     *
     * @param wsdlUrl
     * @return
     */
    public static List<Operation> getPortTypeOperations(String wsdlUrl) {
        List<Operation> operationList = new ArrayList();
        try {
            WSDLReader reader = new AbilityWSDLReaderImpl();
            reader.setFeature("javax.wsdl.verbose", false);
            Definition definition = reader.readWSDL(wsdlUrl.toString());
            Map<String, PortTypeImpl> defMap = definition.getAllPortTypes();
            Collection<PortTypeImpl> collection = defMap.values();
            for (PortTypeImpl portType : collection) {
                operationList.addAll(portType.getOperations());
            }
        } catch (WSDLException e) {
            System.out.println("get wsdl operation fail.");
            e.printStackTrace();
        }
        return operationList;
    }
    /**
     * 参考SoapMessageBuilder.SoapMessageBuilder(URL wsdlUrl)方法
     * 获取portType中的所有operation
     *
     * @param wsdlUrl
     * @return
     */
    public static List<Operation> getPortTypeOperationsFromFile(String wsdlUrl) {
        List<Operation> operationList = new ArrayList();
        try {
            URL wsdlURL = new File(wsdlUrl).toURI().toURL();
            WSDLReader reader = new AbilityWSDLReaderImpl();
            reader.setFeature("javax.wsdl.verbose", false);
            Definition definition = reader.readWSDL(wsdlURL.toString());
            Map<String, PortTypeImpl> defMap = definition.getAllPortTypes();
            Collection<PortTypeImpl> collection = defMap.values();
            for (PortTypeImpl portType : collection) {
                operationList.addAll(portType.getOperations());
            }
        } catch (WSDLException e) {
            System.out.println("get wsdl operation fail.");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("get wsdl file fail.");
            e.printStackTrace();
        }
        return operationList;
    }
    /**
     * 根据wsdlUrl获取operation列表
     *
     * @param wsdlUrl
     * @return
     */
    public static List<String> getOperationByUrl(String wsdlUrl) {
        List<String> resultList = new ArrayList<>();
        List<Operation> operationList = getPortTypeOperations(wsdlUrl);
        for (Operation operation : operationList) {
            resultList.add(operation.getName());
        }
        return resultList;
    }

    /**
     * 根据wsdl文件获取operation列表
     *
     * @param wsdlFile
     * @return
     */
    public static List<String> getOperationByFile(String wsdlFile) {
        List<String> operaList = new ArrayList<>();
        try {
            File file = new File(wsdlFile);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);
            // 获取根节点
            Element elementRoot = document.getRootElement();
            //xpath查询body节点
            Node portTypeNode = elementRoot.selectSingleNode("./*[starts-with(name(),'portType')]");
            List<Node> nodeList = portTypeNode.selectNodes("./*[starts-with(name(),'operation')]");
            for (Node node : nodeList) {
                Element element = (Element) node;
                operaList.add(element.attribute(0).getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return operaList;
    }
    /**
     * 参考SoapMessageBuilder.SoapMessageBuilder(URL wsdlUrl)方法
     * 获取binding节点的所有operation
     *
     * @param wsdlUrl
     * @return
     */
    public static List<String> getAllBindingOperation(String wsdlUrl) {
        List<BindingOperation> operationList = new ArrayList();
        List<String> nameList = new ArrayList();
        try {
            WSDLReader reader = new AbilityWSDLReaderImpl();
            reader.setFeature("javax.wsdl.verbose", false);
            Definition definition = reader.readWSDL(wsdlUrl.toString());
            Map<String, BindingImpl> defMap = definition.getAllBindings();
            Collection<BindingImpl> collection = defMap.values();
            for (BindingImpl binding : collection) {
                operationList.addAll(binding.getBindingOperations());
            }
            for (BindingOperation operation:operationList) {
                nameList.add(operation.getName());
            }
        } catch (WSDLException e) {
            System.out.println("get wsdl operation fail.");
            e.printStackTrace();
        }
        return nameList;
    }
    /**
     * 参考SoapMessageBuilder.SoapMessageBuilder(URL wsdlUrl)方法
     * 获取type中的所有schema
     *
     * @param wsdlUrl
     * @return
     */
    public static Types getTypesFromFile(String wsdlUrl) {
        try {
            URL wsdlURL = new File(wsdlUrl).toURI().toURL();
            WSDLReader reader = new AbilityWSDLReaderImpl();
            reader.setFeature("javax.wsdl.verbose", false);
            Definition definition = reader.readWSDL(wsdlURL.toString());
            Types types = definition.getTypes();
            return types;
        } catch (WSDLException e) {
            System.out.println("get wsdl operation fail.");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("get wsdl file fail.");
            e.printStackTrace();
        }
        return null;
    }
}
