package com.yao.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import java.io.StringWriter;

/**
 * @className XmlUtil
 * @description: xml工具类
 * @author: yaoyao
 * @create: 2020/03/06 14:05
 */
public class XmlUtil {
    private static XmlMapper xmlMapper = new XmlMapper();
    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * xml字符串转成JSON格式字符串
     *
     * @param xml
     * @return      
     */
    public static String convertXmlToJson(String xml) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON read = xmlSerializer.read(xml);
        return read.toString();
    }
}
