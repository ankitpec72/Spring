package com.axel.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.axel.configuration.RestCxfConfiguration;

/**
 * The Class Application initializes the REST services using Spring-Boot
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.axel")
@EnableJpaRepositories(basePackages = {"com.axel.dao"})
@EntityScan("com.axel.entity")
public class Application extends SpringBootServletInitializer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
    	
        SpringApplication.run(new Object[]{Application.class,RestCxfConfiguration.class}, args);
    }

}
