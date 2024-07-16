package com.ruhlinit.spring_bookstore_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBookstoreManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookstoreManagementApplication.class, args);
	}

}
