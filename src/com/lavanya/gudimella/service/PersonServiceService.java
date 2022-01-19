/**
 * PersonServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lavanya.gudimella.service;

public interface PersonServiceService extends javax.xml.rpc.Service {
    public java.lang.String getPersonServiceAddress();

    public com.lavanya.gudimella.service.PersonService getPersonService() throws javax.xml.rpc.ServiceException;

    public com.lavanya.gudimella.service.PersonService getPersonService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
