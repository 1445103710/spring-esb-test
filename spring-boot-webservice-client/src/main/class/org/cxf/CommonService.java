package org.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.3
 * 2019-10-31T21:12:27.762+08:00
 * Generated source version: 3.3.3
 *
 */
@WebService(targetNamespace = "http://www.WebService.demo.example.com", name = "CommonService")
@XmlSeeAlso({ObjectFactory.class})
public interface CommonService {

    @WebMethod(operationName = "HelloWorlda")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "HelloWorldaResponse", targetNamespace = "http://www.WebService.demo.example.com", partName = "parameters")
    public HelloWorldaResponse helloWorlda(

        @WebParam(partName = "parameters", name = "HelloWorlda", targetNamespace = "http://www.WebService.demo.example.com")
        HelloWorlda parameters
    );

    @WebMethod(operationName = "HelloWorld")
    @RequestWrapper(localName = "HelloWorld", targetNamespace = "http://www.WebService.demo.example.com", className = "org.cxf.HelloWorld")
    @ResponseWrapper(localName = "HelloWorldResponse", targetNamespace = "http://www.WebService.demo.example.com", className = "org.cxf.HelloWorldResponse")
    @WebResult(name = "String", targetNamespace = "")
    public java.lang.String helloWorld(

        @WebParam(name = "HelloName", targetNamespace = "")
        java.lang.String helloName
    );
}
