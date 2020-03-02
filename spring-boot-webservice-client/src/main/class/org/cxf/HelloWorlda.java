
package org.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>HelloWorlda complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="HelloWorlda"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Quote" type="{http://www.WebService.demo.example.com}quote" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HelloWorlda", propOrder = {
    "quote"
})
public class HelloWorlda {

    @XmlElement(name = "Quote")
    protected Quote quote;

    /**
     * 获取quote属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Quote }
     *     
     */
    public Quote getQuote() {
        return quote;
    }

    /**
     * 设置quote属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Quote }
     *     
     */
    public void setQuote(Quote value) {
        this.quote = value;
    }

}
