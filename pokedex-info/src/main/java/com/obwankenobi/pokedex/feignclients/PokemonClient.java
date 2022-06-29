package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${feign.clients.pokemon.url}", name = "${feign.clients.pokemon.name}")
public interface PokemonClient {

	@GetMapping(value = "${feign.clients.pokemon.resource}")
	String getPokemonData(@PathVariable("name") String name);
}
