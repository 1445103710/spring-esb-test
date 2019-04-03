package com.yao.springbootvalid.valid;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

/**
 * 通过扩展的xsd验证xml
 * <p/>
 * 备注：JDK自带的Dom4j方式验证
 *
 * @author yangpengfei
 */
public class ValidateXsdByDom4j {

    public static void main(String[] args) throws DocumentException {
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            validateXsdBy();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
        validateXsdBy();
    }
    public static void validateXsdBy(){
        try {
            String basePath = ValidateXsdByDom4j.class.getResource("/").getFile();

            String xmlFileName = basePath + "letter.xml";
            String xsdFileName = basePath + "letter.xsd";

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            factory.setSchema(schemaFactory.newSchema(new Source[]{new StreamSource(xsdFileName)}));
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();

            SAXReader reader = new SAXReader(parser.getXMLReader());
            SimpleErrorHandler errorHandler = new SimpleErrorHandler();
            //reader.setErrorHandler(errorHandler);
            Document document = reader.read(new InputSource(xmlFileName));
//            System.out.println(errorHandler.isErrorResult());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXParseException ex) {
            System.out.println(" fails to validate because: \n");
            System.out.println(ex.getMessage());
            System.out.println("At: " + ex.getLineNumber()
                    + ":" + ex.getColumnNumber());
            System.out.println();
        }catch (SAXException e) {
            System.out.println(e.getCause());
            System.out.println(e.getException());
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (DocumentException e){
            e.printStackTrace();
        }
    }
}
