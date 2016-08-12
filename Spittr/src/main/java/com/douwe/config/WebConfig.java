package com.douwe.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Created by Milan_Verheij on 02-08-16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.douwe")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public MessageSource messageSource() {
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    	messageSource.setBasename("file:///etc/com.douwe/messages"); // TODO
    	messageSource.setCacheSeconds(10);
    	return messageSource;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        super.addResourceHandlers(registry);
    }
    
	// JSP
    
//	@Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }
    
    // Tiles
    @Bean
    public TilesConfigurer tilesConfigurer() {
    	TilesConfigurer tiles = new TilesConfigurer();
    	tiles.setDefinitions(new String[] {
    			"/WEB-INF/layout/tiles.xml"
    	});
    	tiles.setCheckRefresh(true);
    	return tiles;
    }
    
    @Bean
    public ViewResolver viewResolver() {
    	return new TilesViewResolver();
    }
    
    // Thymeleaf
    
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//    	ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//    	viewResolver.setTemplateEngine(templateEngine);
//    	return new TilesViewResolver(); // Spring view resolver wat uiteindelijk een thymeleaf template is
//    }
//
//    @Bean
//    public TemplateEngine templateEngine(TemplateResolver templateResolver) {
//    	SpringTemplateEngine templateEngine = new SpringTemplateEngine(); // Spring enabled thymeleaf engine parsing templates and rendering results 
//    	templateEngine.setTemplateResolver(templateResolver);
//    	return templateEngine;
//    }
//
//    @Bean
//    public TemplateResolver templateResolver() { //locate the templates
//    	TemplateResolver templateResolver = new ServletContextTemplateResolver();
//    	templateResolver.setPrefix("/WEB-INF/templates/");
//    	templateResolver.setSuffix(".html");
//    	templateResolver.setTemplateMode("HTML5");
//    	return templateResolver;
//    }
    
}
