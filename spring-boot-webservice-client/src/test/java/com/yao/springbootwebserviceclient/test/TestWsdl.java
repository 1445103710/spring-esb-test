package com.yao.springbootwebserviceclient.test;

import com.yao.springbootwebserviceclient.util.wsdl.WsdlUtil;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import java.util.List;
import java.util.Map;

/**
 * @className TestWsdl
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/10/25 14:17
 */
public class TestWsdl {
    @Test
    public void testWsdl4j() throws WSDLException {
        WSDLFactory factory=WSDLFactory.newInstance();
        WSDLReader reader=factory.newWSDLReader();
        reader.setFeature("javax.wsdl.verbose",true);
        reader.setFeature("javax.wsdl.importDocuments",true);
        reader.setFeature("com.ibm.wsdl.parseXMLSchemas",true);

        Definition def=reader.readWSDL("http://localhost:8081/yaoyao/CommonService?wsdl");
        Map allBindings = def.getAllBindings();
        Map allPortTypes = def.getAllPortTypes();
        Map allServices = def.getAllServices();
        //System.out.println(def);
        System.out.println("1-------------------------------------华丽分界线------------------------------------1");
        allBindings.forEach((a,k)->{
            System.out.println("allBindings-->>>key:"+a);
            System.out.println("allBindings-->>>value:"+k);
        });
        System.out.println("2-------------------------------------华丽分界线------------------------------------2");
        allPortTypes.forEach((a,k)->{
            System.out.println("allPortTypes-->>>key:"+a);
            System.out.println("allPortTypes-->>>value:"+k);
        });
        System.out.println("3-------------------------------------华丽分界线------------------------------------3");
        allServices.forEach((a,k)->{
            System.out.println("allServices-->>>key:"+a);
            System.out.println("allServices-->>>value:"+k);
        });
        System.out.println("4-------------------------------------华丽分界线------------------------------------4");

        String namespaceURI=def.getTargetNamespace();
        System.out.println(namespaceURI);


        Map portTypes = def.getPortTypes();
        portTypes.forEach((a,k)->{
            System.out.println("5xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx华丽分界线xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx5");
            System.out.println("allPortTypes-->>>key:"+a);
            System.out.println("5-------------------------------------华丽分界线------------------------------------5");
            System.out.println("allPortTypes-->>>value:"+k);
            System.out.println("5xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx华丽分界线xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx5");

        });

        Types types = def.getTypes();
        List extensibilityElements = types.getExtensibilityElements();
        extensibilityElements.stream().forEach((a)->{
            System.out.println(a.toString());
        });
    }
    @Test
    public void getTest2(){
        List<Operation> portTypeOperations = WsdlUtil.getPortTypeOperations("http://localhost:8081/yaoyao/CommonService?wsdl");
        portTypeOperations.stream().forEach((a)-> {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx华丽分界线xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            //System.out.println(a);
            System.out.println(a.getInput().getName());
            System.out.println(a.getFaults());
            System.out.println(a.getOutput().getMessage());
            System.out.println(a.getOutput().getName());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx华丽分界线xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        });
    }
    @Test
    public void readUrlPortType(){
        List<Operation> portTypeOperations = WsdlUtil.getPortTypeOperations("http://localhost:8081/yaoyao/CommonService?wsdl");
        portTypeOperations.stream().forEach((a)->{
            System.out.println(a.getName());
        });
    }

    @Test
    public void readFilePortType(){
        String wsdlFileName = "/Users/yaoyao/local/work/ability/UsrSer/META-INF/UsrSer.wsdl";
        List<Operation> portTypeOperationsFromFile = WsdlUtil.getPortTypeOperationsFromFile(wsdlFileName);
        portTypeOperationsFromFile.stream().forEach((a)->{
            System.out.println(a.getName());
        });
    }

    @Test
    public void readFileSchema(){
        String wsdlFileName = "/Users/yaoyao/local/work/ability/UsrSer/META-INF/UsrSer.wsdl";
        Types typesFromFile = WsdlUtil.getTypesFromFile(wsdlFileName);

        List extensibilityElements = typesFromFile.getExtensibilityElements();
        extensibilityElements.stream().forEach((a)->{
            System.out.println(a.toString());
        });

    }
}
