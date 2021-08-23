package com.devco.seleccionprocesos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SeleccionprocesosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleccionprocesosApplication.class, args);
	}

}
