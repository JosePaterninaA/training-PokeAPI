package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://pokeapi.co", name = "pokemon-client")
public interface PokemonClient {

	@RequestMapping(value = "/api/v2/pokemon/{name}/", method = RequestMethod.GET)
	public String getPokemonData(@PathVariable("name") String name);
}
