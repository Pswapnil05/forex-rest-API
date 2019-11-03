package com.innovecture.forex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ForexApplication {

	private static final Logger logger = LoggerFactory.getLogger(ForexApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ForexApplication.class, args);
		logger.info("INFO MESSAGE -- Spring Boot Application run method executed");
	}

}
