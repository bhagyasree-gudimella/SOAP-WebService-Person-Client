package com.lavanya.gudimella.controller;

import java.rmi.RemoteException; 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lavanya.gudimella.dto.Person;
import com.lavanya.gudimella.service.PersonServiceProxy;

@RestController
@RequestMapping("/person/list")
public class PersonsListController {

	@RequestMapping(value="/personsList", method=RequestMethod.GET)
	private ModelAndView modelAndView() throws RemoteException {

		PersonServiceProxy personServiceProxy = new PersonServiceProxy();
		System.setProperty("proxyHost", "PersonServiceProxy.tomcat.com");
		System.setProperty("proxyPort", "8080");
		
		Person[] personsList = personServiceProxy.getAllPersons();
		
		ModelAndView modelAndView = new ModelAndView("ViewPersonsList");
		modelAndView.addObject("personsList", personsList);
		return modelAndView;
	}
}
