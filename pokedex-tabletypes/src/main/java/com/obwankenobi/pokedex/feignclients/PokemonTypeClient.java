package com.obwankenobi.pokedex.feignclients;

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
	@GetMapping(value = "${feign.clients.type.resource}")
	String getPokemonData(@PathVariable("name") String name);
}
