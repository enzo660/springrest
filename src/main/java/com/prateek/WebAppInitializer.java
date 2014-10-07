package com.prateek;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * Added this class to add filters.
 * Couldn't add filters to WebInitializer
 */
public class WebAppInitializer implements WebApplicationInitializer {
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    
        FilterRegistration.Dynamic registration = servletContext.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
        registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD),
                false, "dispatcher");
        
    }
	
}
