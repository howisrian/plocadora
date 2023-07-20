package com.plocadora.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PlocadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlocadoraApplication.class, args);
	}

}
