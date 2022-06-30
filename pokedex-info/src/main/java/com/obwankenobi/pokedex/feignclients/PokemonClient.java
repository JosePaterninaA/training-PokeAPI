package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente openfeign que consume la API pokeapi/pokemon
 */
@FeignClient(url = "${feign.clients.pokemon.url}", name = "${feign.clients.pokemon.name}")
public interface PokemonClient {
	/**
	 * Obtiene JSON string con información sobre el pokemon dado un nombre
	 * @param name
	 * @return {@link String}
	 */
	@GetMapping(value = "${feign.clients.pokemon.resource}")
	String getPokemonData(@PathVariable("name") String name);
}
