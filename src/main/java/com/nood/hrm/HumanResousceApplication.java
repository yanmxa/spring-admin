package com.nood.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan(basePackages = {"com.nood.hrm.mapper"})
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HumanResousceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResousceApplication.class, args);
	}

}
