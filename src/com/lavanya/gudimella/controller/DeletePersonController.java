package com.lavanya.gudimella.controller;

import java.rmi.RemoteException; 

import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lavanya.gudimella.dto.Person;
import com.lavanya.gudimella.service.PersonServiceProxy;

@RestController
@RequestMapping("/person/deletePerson")
public class DeletePersonController {
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	private ModelAndView bindDeletePerson() {
		ModelAndView modelAndView = new ModelAndView("DeleteUser");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	private ModelAndView deletePerson(@ModelAttribute("person") Person person, ModelAndView modelAndView) throws RemoteException {
		
		PersonServiceProxy personServiceProxy = new PersonServiceProxy();
		System.setProperty("proxyHost", "PersonServiceProxy.tomcat.com");
		System.setProperty("proxyPort", "8080");
		
		Person mPerson = personServiceProxy.findByEmail(person.getEmail_address());
		personServiceProxy.deletePerson(mPerson);
		
		modelAndView = new ModelAndView("Success");
		String result = person.getEmail_address() +", has been deleted successfully";
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
}
