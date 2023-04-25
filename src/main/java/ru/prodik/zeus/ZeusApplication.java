package ru.prodik.zeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZeusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeusApplication.class, args);
	}



}
