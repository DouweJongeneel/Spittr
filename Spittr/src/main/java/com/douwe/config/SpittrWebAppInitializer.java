package com.douwe.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Milan_Verheij on 02-08-16.
 *
 * Dispatcher Servlet uit Spring boek pg 134
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
    
    @Override
    protected void customizeRegistration(Dynamic registration) {
    	registration.setMultipartConfig(
    			new MultipartConfigElement("/tmp/spittr/uploads"));
    }
}
