package com.example.Adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories(basePackages={"com.example.Repositiory"})
@EntityScan(basePackages = {"com.example.Entity"})
@ComponentScan(basePackages={"com.example.controller","com.example.service","com.example.exceptionhandler","com.example.customException"})
@SpringBootApplication
public class AdminserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminserviceApplication.class, args);
		System.out.println("Welcome EveryOne To Admin Service");
	}

}
