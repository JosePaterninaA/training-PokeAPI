package com.obwankenobi.pokedex.feignclients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author nathaly.salamanca
 *
 */
@FeignClient(url = "${feign.clients.type.url}", name = "${feign.clients.type.name}")
public interface PokemonTypeClient {
	/**
	 * 
	 * @param name
	 * @return
	 */
	@CircuitBreaker(name = "pokemon-type-client", fallbackMethod = "getPokemonTypeFallback")
	@GetMapping(value = "${feign.clients.type.resource}")
	String getPokemonData(@PathVariable("name") String name);

	default String getPokemonTypeFallback(String name, Throwable error){
		return Strings.EMPTY;
	}
}
