package com.subba.jwtsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JwtsecurityApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context;
		context = SpringApplication.run(JwtsecurityApplication.class, args);

		//context.getBean("")
	}




}
