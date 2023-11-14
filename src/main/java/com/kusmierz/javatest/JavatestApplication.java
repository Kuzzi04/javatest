package com.kusmierz.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling		// necessary for scheduled spam-detection
public class JavatestApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavatestApplication.class, args);

	}

}
