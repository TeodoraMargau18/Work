package com.playtika.DBManagementFromSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;

@ComponentScan("com.playtika")
@EntityScan("com.playtika")
@SpringBootApplication
public class DbManagementFromSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbManagementFromSpringApplication.class, args);
	}

}
