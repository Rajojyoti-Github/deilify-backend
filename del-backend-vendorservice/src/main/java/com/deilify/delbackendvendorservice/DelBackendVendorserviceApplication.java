package com.deilify.delbackendvendorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.deilify.delbackendvendorservice", "com.deilify.delbackendvendorservice.util"})
@PropertySource("classpath:application.properties")
public class DelBackendVendorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelBackendVendorserviceApplication.class, args);
	}

}

