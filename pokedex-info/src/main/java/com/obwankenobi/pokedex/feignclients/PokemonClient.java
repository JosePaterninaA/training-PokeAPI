package com.obwankenobi.pokedex.feignclients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OpenFeign client to consume the pokeapi/pokemon API.
 */
@FeignClient(url = "${feign.clients.pokemon.url}", name = "${feign.clients.pokemon.name}")
public interface PokemonClient {
	/**
	 * Gets a JSON string with the pokemon general information given a name.
	 * @param name
	 * @return {@link String}
	 */
	@CircuitBreaker(name = "pokemon-client", fallbackMethod = "getPokemonFallback")
	@GetMapping(value = "${feign.clients.pokemon.resource}")
	String getPokemonData(@PathVariable("name") String name);

	default String getPokemonFallback(String name, Throwable error){
		return Strings.EMPTY;
	}
}
