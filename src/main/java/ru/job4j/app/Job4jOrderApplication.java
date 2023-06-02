package ru.job4j.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.job4j.app.controller.CardController;
import ru.job4j.app.service.CardService;

@SpringBootApplication
public class Job4jOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Job4jOrderApplication.class, args);
	}

}
