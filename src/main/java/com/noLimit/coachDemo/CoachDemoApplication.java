package com.noLimit.coachDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //component scanning in the current directory
public class CoachDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachDemoApplication.class, args);
	}

}

//@SpringBootApplication(
//		scanBasePackages = {
//				"com.noLimit.util"
//		}
//)