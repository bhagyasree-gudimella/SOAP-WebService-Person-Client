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
@RequestMapping("/person")
public class ViewPersonByIdController {

	@RequestMapping(value="/personById", method=RequestMethod.GET)
	private ModelAndView bindViewPersonByEmail() {
		ModelAndView modelAndView = new ModelAndView("ViewPersonById");
		Person person = new Person();
		modelAndView.addObject("personId", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/personById", method=RequestMethod.POST)
	private ModelAndView viewPersonByEmail(@ModelAttribute("personId") Person person, ModelAndView modelAndView) throws RemoteException {
		System.out.println("Person Id : " +person.getPerson_id());
		
		PersonServiceProxy personServiceProxy = new PersonServiceProxy();
		System.setProperty("proxyHost", "PersonServiceProxy.tomcat.com");
		System.setProperty("proxyPort", "8080");
		
		Person mPerson = personServiceProxy.getPersonById(person.getPerson_id());
		modelAndView = new ModelAndView("ViewPerson");
		modelAndView.addObject("mPerson", mPerson);
		
		return modelAndView;
	}
}
