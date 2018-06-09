package com.userServiceREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class UserServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceRestApplication.class, args);
	}
}
