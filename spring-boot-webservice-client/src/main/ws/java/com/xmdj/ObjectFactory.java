
package com.xmdj;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xmdj package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("yaoyao", "String");
    private final static QName _HelloWorld_QNAME = new QName("http://www.WebService.demo.example.com", "HelloWorld");
    private final static QName _HelloWorldResponse_QNAME = new QName("http://www.WebService.demo.example.com", "HelloWorldResponse");
    private final static QName _HelloWorlda_QNAME = new QName("http://www.WebService.demo.example.com", "HelloWorlda");
    private final static QName _HelloWorldaResponse_QNAME = new QName("http://www.WebService.demo.example.com", "HelloWorldaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xmdj
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloWorld }
     * 
     */
    public HelloWorld createHelloWorld() {
        return new HelloWorld();
    }

    /**
     * Create an instance of {@link HelloWorldResponse }
     * 
     */
    public HelloWorldResponse createHelloWorldResponse() {
        return new HelloWorldResponse();
    }

    /**
     * Create an instance of {@link HelloWorlda }
     * 
     */
    public HelloWorlda createHelloWorlda() {
        return new HelloWorlda();
    }

    /**
     * Create an instance of {@link HelloWorldaResponse }
     * 
     */
    public HelloWorldaResponse createHelloWorldaResponse() {
        return new HelloWorldaResponse();
    }

    /**
     * Create an instance of {@link Quote }
     * 
     */
    public Quote createQuote() {
        return new Quote();
    }

    /**
     * Create an instance of {@link Instant }
     * 
     */
    public Instant createInstant() {
        return new Instant();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "yaoyao", name = "String")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorld }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloWorld }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "HelloWorld")
    public JAXBElement<HelloWorld> createHelloWorld(HelloWorld value) {
        return new JAXBElement<HelloWorld>(_HelloWorld_QNAME, HelloWorld.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorldResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloWorldResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "HelloWorldResponse")
    public JAXBElement<HelloWorldResponse> createHelloWorldResponse(HelloWorldResponse value) {
        return new JAXBElement<HelloWorldResponse>(_HelloWorldResponse_QNAME, HelloWorldResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorlda }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloWorlda }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "HelloWorlda")
    public JAXBElement<HelloWorlda> createHelloWorlda(HelloWorlda value) {
        return new JAXBElement<HelloWorlda>(_HelloWorlda_QNAME, HelloWorlda.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorldaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloWorldaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "HelloWorldaResponse")
    public JAXBElement<HelloWorldaResponse> createHelloWorldaResponse(HelloWorldaResponse value) {
        return new JAXBElement<HelloWorldaResponse>(_HelloWorldaResponse_QNAME, HelloWorldaResponse.class, null, value);
    }

}
