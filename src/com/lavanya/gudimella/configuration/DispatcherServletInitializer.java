package com.lavanya.gudimella.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DispatcherServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		webApplicationContext.setConfigLocation("classpath:SOAP-WebService-Person-Client-servlet.xml");
		
		//initialize diapatcherServlet and pass the applicationContext reference
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		//register diapatcherServlet using servletContext
		ServletRegistration.Dynamic myDispatcherServlet = servletContext.addServlet("SOAP-WebService-Person-Client", dispatcherServlet);
		myDispatcherServlet.setLoadOnStartup(1);
		myDispatcherServlet.addMapping("/");
	}
}
