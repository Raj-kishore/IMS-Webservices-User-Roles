package com.naffal.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Exclude auto configuration for faster startup of the application
// Following auto configuration done by Spring boot:
// DispatcherServletAutoConfiguration, DataSourceAutoConfiguration, JacksonAutoConfiguration, ErrorMvcAutoConfiguration 
// @SpringBootApplication (exclude={JacksonAutoConfiguration.class, JmxAutoConfiguration.class})  
@SpringBootApplication
public class ImsApplication {

	//REST architecture emphasized by Roy Thomas Fielding
	//REST is an architecture unlike SOAP which is a protocol
	public static void main(String[] args) {
		SpringApplication.run(ImsApplication.class, args);
	}

}
