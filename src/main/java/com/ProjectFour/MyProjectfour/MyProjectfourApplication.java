package com.ProjectFour.MyProjectfour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MyProjectfourApplication {


	public static void main(String[] args) {
		SpringApplication.run(MyProjectfourApplication.class, args);
	}

}
