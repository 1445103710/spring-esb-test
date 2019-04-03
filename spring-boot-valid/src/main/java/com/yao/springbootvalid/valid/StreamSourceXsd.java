package com.yao.springbootvalid.valid;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/28 19:19
 * @Description:
 * @see com.yao.springbootvalid.valid
 */
public class StreamSourceXsd {

    public static void main(String[] args) throws IOException{
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<body>\n" +

                "  <username>haha</username>\n" +
//                "  <age></age>\n" +
                "  <call>\n" +
                "    <english>12:122222222:12</english>\n" +
                "    <chinese>str1234</chinese>\n" +
                "  </call>\n" +
                "</body>";
        byte[] bytes = Files.readAllBytes(Paths.get("F:\\java\\interlliJIDE\\lean\\esb\\test\\spring-esb-test\\spring-boot-valid\\target\\classes\\letter.xsd"));
        String xsd = new String(bytes);
        System.out.println(xsd);
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        InputStream[] inputStreams = new InputStream[1];
        inputStreams[0] = new ByteArrayInputStream(xsd.getBytes());
        validateWithXMLSchema(inputStream,inputStreams);
    }
    /**
     * Validates XML against XSD schema
     *
     * @param xml     XML in which the element is being searched
     * @param schemas XSD schemas against which the XML is validated
     * @throws SAXException if the XSD schema is invalid
     * @throws IOException  if the XML at the specified path is missing
     */
    public static void validateWithXMLSchema(InputStream xml, InputStream[] schemas){
        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Source[] sources = new Source[schemas.length];
        for (int i = 0; i < schemas.length; i++) {
            sources[i] = new StreamSource(schemas[i]);
        }
        try {
            Schema schema = factory.newSchema(sources);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
        } catch (SAXParseException e) {
            System.out.println(e.getMessage());
        }catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
