package com.yao.springbootvalid.valid;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/28 15:22
 * @Description:
 * @see com.yao.springbootvalid.valid
 */
public class ESBValidHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println(exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println(exception.getMessage());

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}
