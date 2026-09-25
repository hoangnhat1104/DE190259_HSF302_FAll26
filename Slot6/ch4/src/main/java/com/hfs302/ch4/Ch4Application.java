package com.hfs302.ch4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hfs302.ch4", "service", "runner"})
@EnableJpaRepositories(basePackages = {"repository"})
public class Ch4Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch4Application.class, args);
	}

}
