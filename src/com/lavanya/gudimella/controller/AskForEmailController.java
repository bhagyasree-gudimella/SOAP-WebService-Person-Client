 package com.lavanya.gudimella.controller;
 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lavanya.gudimella.dto.Person;

@RestController
@RequestMapping("/person/emailInfo")
@SessionAttributes("email_address")
public class AskForEmailController {

	@RequestMapping(value="/askForEmail", method=RequestMethod.GET)
	private ModelAndView bindAskEmail() {
		ModelAndView modelAndView = new ModelAndView("AskForEmailAddress");
		Person person = new Person();
		modelAndView.addObject("email_address", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/askForEmail", method=RequestMethod.POST)
	private ModelAndView updatePersonByEmail(@ModelAttribute("email_address") Person person, ModelAndView modelAndView) {
		System.out.println("Email address : " +person.getEmail_address());
		modelAndView = new ModelAndView("redirect:/person/update/updatePerson");
		return modelAndView;
	}
}
