package com.supplier.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:sql.properties")
public class SupplierManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierManagerApplication.class, args);
	}

}
