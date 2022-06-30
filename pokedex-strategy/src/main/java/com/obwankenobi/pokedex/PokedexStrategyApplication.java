package com.obwankenobi.pokedex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokedexStrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexStrategyApplication.class, args);
	}

}
