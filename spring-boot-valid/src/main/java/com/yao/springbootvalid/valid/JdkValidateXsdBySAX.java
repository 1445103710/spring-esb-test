package com.yao.springbootvalid.valid;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/28 10:42
 * @Description:
 * @see com.yao.springbootvalid.valid
 */
import com.alibaba.fastjson.JSONObject;

import org.dom4j.util.XMLErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

/**
 * 通过扩展的xsd验证xml
 * <p/>
 * 备注：JDK自带的SAX方式验证
 *
 * @author yangpengfei
 */
public class JdkValidateXsdBySAX {

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

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            factory.setSchema(schemaFactory.newSchema(new Source[]{new StreamSource(xsdFileName)}));
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();

            XMLReader reader = parser.getXMLReader();
            SimpleErrorHandler errorHandler = new SimpleErrorHandler ();
            reader.setErrorHandler(errorHandler);
            reader.parse(new InputSource(xmlFileName));
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
