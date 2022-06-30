package com.obwankenobi.pokedex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PokedexTabletypesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexTabletypesApplication.class, args);
	}

}
