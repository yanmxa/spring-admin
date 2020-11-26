package com.nood.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.nood.hrm.mapper"})
public class HumanResousceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResousceApplication.class, args);
	}

}
