// JavaGameServerApplication.java - Main entry point for starting Spring Boot application.
package com.example.javagameserver;

// SpringApplication class is main entry point for starting Spring Boot application.
// Called in main(), see below.
// Initialises Spring framework, initialises and sets up application for execution.
import org.springframework.boot.SpringApplication;

// Required for using @SpringBootApplication below.
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication annotation marks the class as a Spring Boot application and
// enables auto-configuration features. Used on main class that contains main() method.
// WebSocketConfig contains configuration coding (i.e. @configuration annotations.)
@SpringBootApplication
public class JavaGameServerApplication {

	// Launches application.
	public static void main(String[] args) {
		SpringApplication.run(JavaGameServerApplication.class, args);
	}

}
