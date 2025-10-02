package com.example.SriLankaPassport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PassportApplication {

	public static void main(String[] args) {SpringApplication.run(PassportApplication.class, args);
	}

}
