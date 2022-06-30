package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${feign.clients.type.url}", name = "${feign.clients.type.name}")
public interface PokemonTypeClient {

	@GetMapping(value = "${feign.clients.type.resource}")
	String getPokemonData(@PathVariable("name") String name);
}
