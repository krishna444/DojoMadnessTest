package com.kpaudel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Startup application program
 * @author krishna
 *
 */
@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String... args) {
		LOGGER.info("Application is going to start...");
		SpringApplication.run(Application.class, args);
	}
}
