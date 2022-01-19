package com.lavanya.gudimella.client;

import java.rmi.RemoteException;

import com.lavanya.gudimella.dto.Person;
import com.lavanya.gudimella.service.PersonServiceProxy;

public class PersonClient {
	public static void main(String[] args) throws RemoteException {
		PersonServiceProxy personServiceProxy = new PersonServiceProxy();
		System.setProperty("proxyHost", "PersonServiceProxy.tomcat.com");
		System.setProperty("proxyPort", "8080");
		
		Person[] personsList = personServiceProxy.getAllPersons();
		for(Person person : personsList) {
			System.out.println(person.getFirst_name());
		}
	}
}
