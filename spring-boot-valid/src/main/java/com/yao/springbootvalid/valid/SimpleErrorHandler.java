package com.yao.springbootvalid.valid;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author yaoyao
 * @version 1.0
 * @createDate 2019/03/28 10:40
 * @Description:
 * @see com.yao.springbootvalid.valid
 */
public class SimpleErrorHandler implements ErrorHandler {
    private boolean errorResult = true;

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("waring:" + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        setErrorResult(false);
        System.out.println("error:" + e.getMessage()+ JSONObject.toJSONString(e));
    }
    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("fatalError:" + e.getMessage());
    }

    public boolean isErrorResult() {
        return errorResult;
    }

    public void setErrorResult(boolean errorResult) {
        this.errorResult = errorResult;
    }
}
