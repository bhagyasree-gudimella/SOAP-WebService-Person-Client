package com.lavanya.gudimella.service;

public class PersonServiceProxy implements com.lavanya.gudimella.service.PersonService {
  private String _endpoint = null;
  private com.lavanya.gudimella.service.PersonService personService = null;
  
  public PersonServiceProxy() {
    _initPersonServiceProxy();
  }
  
  public PersonServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceProxy();
  }
  
  private void _initPersonServiceProxy() {
    try {
      personService = (new com.lavanya.gudimella.service.PersonServiceServiceLocator()).getPersonService();
      if (personService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personService != null)
      ((javax.xml.rpc.Stub)personService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.lavanya.gudimella.service.PersonService getPersonService() {
    if (personService == null)
      _initPersonServiceProxy();
    return personService;
  }
  
  public com.lavanya.gudimella.dto.Person[] getAllPersons() throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.getAllPersons();
  }
  
  public void savePerson(com.lavanya.gudimella.dto.Person person) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    personService.savePerson(person);
  }
  
  public void updatePerson(com.lavanya.gudimella.dto.Person person) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    personService.updatePerson(person);
  }
  
  public void deletePerson(com.lavanya.gudimella.dto.Person person) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    personService.deletePerson(person);
  }
  
  public com.lavanya.gudimella.dto.Person getPersonById(int person_id) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.getPersonById(person_id);
  }
  
  public com.lavanya.gudimella.dto.Person findByEmail(java.lang.String email_address) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.findByEmail(email_address);
  }
  
  public boolean findUser(java.lang.String email_address) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.findUser(email_address);
  }
  
  
}