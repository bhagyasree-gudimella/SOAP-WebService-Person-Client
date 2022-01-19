package com.lavanya.gudimella.controller;

import java.rmi.RemoteException; 

import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.lavanya.gudimella.dto.Person;
import com.lavanya.gudimella.service.PersonServiceProxy;

@RestController
@RequestMapping("/person/update")
public class UpdatePersonController {

	@RequestMapping(value="/updatePerson", method=RequestMethod.GET)
	private ModelAndView bindUpdateForm() {
		ModelAndView modelAndView = new ModelAndView("UpdatePerson");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/updatePerson", method=RequestMethod.POST)
	private ModelAndView updatePerson(@SessionAttribute("email_address") Person sPerson, @ModelAttribute("person") Person person, ModelAndView modelAndView) throws RemoteException {
		
		PersonServiceProxy personServiceProxy = new PersonServiceProxy();
		System.setProperty("proxyHost", "PersonServiceProxy.tomcat.com");
		System.setProperty("proxyPort", "8080");
		
		//get the person from database
		Person mPerson = personServiceProxy.findByEmail(sPerson.getEmail_address());
		
		mPerson.setAddress(person.getAddress());
		mPerson.setCity(person.getCity());
		mPerson.setState(person.getState());
		mPerson.setCountry(person.getCountry());
		mPerson.setZipcode(person.getZipcode());
		mPerson.setPhone_number(person.getPhone_number());
		mPerson.setBank_name(person.getBank_name());
		mPerson.setAccount_details(person.getAccount_details());
		
		personServiceProxy.updatePerson(mPerson);
		
		modelAndView = new ModelAndView("Success");
		String result = sPerson.getEmail_address() +", has been updated successfully";
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
}
