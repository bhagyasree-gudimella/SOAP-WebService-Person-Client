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
@RequestMapping("/person/bankInfo")
public class BankInfoController {
	
	@RequestMapping(value="/addBankInfo", method=RequestMethod.GET)
	private ModelAndView bindBankInfo() {
		ModelAndView modelAndView = new ModelAndView("BankInfo");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/addBankInfo", method=RequestMethod.POST)
	private ModelAndView addContactInfo(@SessionAttribute("person") Person mPerson, @ModelAttribute("person") Person person, ModelAndView modelAndView) throws RemoteException {
		System.out.println("First name : " +mPerson.getFirst_name());
		System.out.println("Address : " +mPerson.getAddress());
		System.out.println("Bank name : " +person.getBank_name());
		
		//mPerson.setPerson_id(1);
		mPerson.setBank_name(person.getBank_name());
		mPerson.setAccount_details(person.getAccount_details());
		mPerson.setSsn_number(person.getSsn_number());
		
		PersonServiceProxy personServiceProxy = new PersonServiceProxy();
		System.setProperty("proxyHost", "PersonServiceProxy.tomcat.com");
		System.setProperty("proxyPort", "8080");
		
		personServiceProxy.savePerson(mPerson);
		
		modelAndView = new ModelAndView("RegistrationSuccess");
		modelAndView.addObject("mPerson", mPerson);
		
		return modelAndView;
	}
}
