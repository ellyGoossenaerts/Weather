
package com.mycompany.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.soap package. 
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

    private final static QName _DuplicatorResponse_QNAME = new QName("http://soap.mycompany.com/", "duplicatorResponse");
    private final static QName _Duplicator_QNAME = new QName("http://soap.mycompany.com/", "duplicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Duplicator }
     * 
     */
    public Duplicator createDuplicator() {
        return new Duplicator();
    }

    /**
     * Create an instance of {@link DuplicatorResponse }
     * 
     */
    public DuplicatorResponse createDuplicatorResponse() {
        return new DuplicatorResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuplicatorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.mycompany.com/", name = "duplicatorResponse")
    public JAXBElement<DuplicatorResponse> createDuplicatorResponse(DuplicatorResponse value) {
        return new JAXBElement<DuplicatorResponse>(_DuplicatorResponse_QNAME, DuplicatorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duplicator }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.mycompany.com/", name = "duplicator")
    public JAXBElement<Duplicator> createDuplicator(Duplicator value) {
        return new JAXBElement<Duplicator>(_Duplicator_QNAME, Duplicator.class, null, value);
    }

}
