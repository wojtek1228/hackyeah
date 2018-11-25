package com.hackyeah.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.hackyeah")
@EnableScheduling
public class MainAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}
}
