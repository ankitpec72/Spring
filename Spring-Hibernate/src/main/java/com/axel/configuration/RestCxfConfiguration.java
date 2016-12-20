package com.axel.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * The Class RestCxfConfiguration initializes the REST beans annotated with @PATH and @PROVIDER configuration
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 * 
 */
@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class RestCxfConfiguration {

	/** The Constant logger. */
	private static final Log logger = LogFactory.getLog(RestCxfConfiguration.class);

	/** The ctx. */
	@Autowired
	private ApplicationContext ctx;

	/** The cxf path. */
	@Value("${cxf.services.path}")
	private String cxfPath;

	/** The log requests. */
	@Value("${cxf.log.requests}")
	private boolean logRequests;

	/**
	 * Cxf servlet registration bean method redirects all resource calls having URI cxfPath
	 * to CXFServlet.
	 *
	 * @return the servlet registration bean
	 */
	@Bean
	public ServletRegistrationBean cxfServletRegistrationBean() {
		return new ServletRegistrationBean(new CXFServlet(), cxfPath);
	}

	/**
	 * Jax rs server method registers REST service beans annotated with @PATH, @PROVIDER to
	 * Server. It also adds interceptors for incoming REST service calls which in configurable withh
	 * boolean variable mentioned in property file
	 *
	 * @return the server
	 */
	@Bean
	public Server jaxRsServer() {
		// Find all beans annotated with @Path
		List<Object> serviceBeans = new ArrayList<Object>(ctx.getBeansWithAnnotation(Path.class).values());
		logger.info("Registering service beans: " + serviceBeans);

		// Find all beans annotated with @Providers
		List<Object> providers = new ArrayList<Object>(ctx.getBeansWithAnnotation(Provider.class).values());
		logger.info("Registering providers: " + providers);

		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setBus(ctx.getBean(SpringBus.class));
		factory.setAddress("/");
		factory.setServiceBeans(serviceBeans);
		factory.setProviders(providers);
		Server server = factory.create();

		if (logRequests) {
			server.getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
		}

		return server;
	}

	/**
	 * Json provider registers Jackson as parser and conversion of data to
	 * Json and others required types.
	 *
	 * @param objectMapper the object mapper
	 * @return the jackson json provider
	 */
	@Bean
	@ConditionalOnMissingBean
	public JacksonJsonProvider jsonProvider(ObjectMapper objectMapper) {
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.setMapper(objectMapper);
		return provider;
	}
	
	/**
	 * Object mapper.
	 *
	 * @return the object mapper
	 */
	@Bean
	@ConditionalOnMissingBean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
