package com.plocadora.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.plocadora.projeto.repository.ClienteRepository;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableJpaRepositories(basePackageClasses = ClienteRepository.class)
public class PlocadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlocadoraApplication.class, args);
	}

}
