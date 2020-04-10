//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.21 at 02:45:08 PM CET 
//


package com.spring.batch.xml.job.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.spring.batch.xml.job.domain package. 
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

    private final static QName _UserGroup_QNAME = new QName("http://www.example.org/User", "UserGroup");
    private final static QName _EmployeeGroup_QNAME = new QName("http://www.example.org/User", "EmployeeGroup");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.spring.batch.xml.job.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserGroups }
     * 
     */
    public UserGroups createUserGroups() {
        return new UserGroups();
    }

    /**
     * Create an instance of {@link EmployeeGroups }
     * 
     */
    public EmployeeGroups createEmployeeGroups() {
        return new EmployeeGroups();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/User", name = "UserGroup")
    public JAXBElement<UserGroups> createUserGroup(UserGroups value) {
        return new JAXBElement<UserGroups>(_UserGroup_QNAME, UserGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/User", name = "EmployeeGroup")
    public JAXBElement<EmployeeGroups> createEmployeeGroup(EmployeeGroups value) {
        return new JAXBElement<EmployeeGroups>(_EmployeeGroup_QNAME, EmployeeGroups.class, null, value);
    }

}
