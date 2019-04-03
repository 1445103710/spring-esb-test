package com.yao.springbootvalid.valid;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/28 17:01
 * @Description:
 * @see com.yao.springbootvalid.valid
 */
public class ValidateTest {
    public static void main(String[] args) {
        SchemaFactory factory = SchemaFactory.newInstance(
                "http://www.w3.org/2001/XMLSchema");
        String basePath = JdkValidateXsdBySAX.class.getResource("/").getFile();

        String xmlFileName = basePath + "letter.xml";
        String xsdFileName = basePath + "letter.xsd";
        File XMLFile = new File(xmlFileName);
        try{
            URL url = testURL(xsdFileName);
            Schema schema = factory.newSchema(url);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XMLFile);
            try {

                validator.validate(source);

            }catch (SAXParseException e){
                System.out.println(e.toString());
                System.out.println(e.getColumnNumber());
                System.out.println(e.getLineNumber());
                System.out.println(e.getPublicId());
                System.out.println(e.getSystemId());
                System.out.println(e.getMessage());
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static URL testURL(final String url) throws MalformedURLException {
        try {
            return new URL(url);
        } catch (final MalformedURLException e) { }
        return new URL("file:" + url);
    }
}
