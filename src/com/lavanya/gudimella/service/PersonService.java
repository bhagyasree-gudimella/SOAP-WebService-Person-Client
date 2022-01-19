/**
 * PersonService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lavanya.gudimella.service;

public interface PersonService extends java.rmi.Remote {
    public com.lavanya.gudimella.dto.Person[] getAllPersons() throws java.rmi.RemoteException;
    public void savePerson(com.lavanya.gudimella.dto.Person person) throws java.rmi.RemoteException;
    public void updatePerson(com.lavanya.gudimella.dto.Person person) throws java.rmi.RemoteException;
    public void deletePerson(com.lavanya.gudimella.dto.Person person) throws java.rmi.RemoteException;
    public com.lavanya.gudimella.dto.Person getPersonById(int person_id) throws java.rmi.RemoteException;
    public com.lavanya.gudimella.dto.Person findByEmail(java.lang.String email_address) throws java.rmi.RemoteException;
    public boolean findUser(java.lang.String email_address) throws java.rmi.RemoteException;
}
