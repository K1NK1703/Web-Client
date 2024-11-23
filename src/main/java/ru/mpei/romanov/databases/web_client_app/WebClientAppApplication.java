package ru.mpei.romanov.databases.web_client_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WebClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientAppApplication.class, args);
	}

}
