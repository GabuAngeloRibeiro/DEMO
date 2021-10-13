package com.witcher.bestario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication

public class BestarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestarioApplication.class, args);
	}

}
