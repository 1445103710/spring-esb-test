package com.yao.springbootvalid.valid;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/28 10:21
 * @Description:通过扩展的xsd验证xml，JDK自带的DOM方式验证
 * @see com.yao.springbootvalid.valid
 */
public class JdkValidateXsdByDOM {
    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            jdkValidateXsd();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
        jdkValidateXsd();
    }
    public static void jdkValidateXsd(){
        try {
            String basePath = JdkValidateXsdBySAX.class.getResource("/").getFile();

            String xmlFileName = basePath + "letter.xml";
            String xsdFileName = basePath + "letter.xsd";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            factory.setSchema(schemaFactory.newSchema(new Source[]{new StreamSource(xsdFileName)}));

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler());

            SimpleErrorHandler errorHandler = new SimpleErrorHandler();
            builder.setErrorHandler(errorHandler);
            Document document = builder.parse(new InputSource(xmlFileName));
            System.out.println(errorHandler.isErrorResult());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
