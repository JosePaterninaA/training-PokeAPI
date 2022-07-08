package com.obwankenobi.pokedex.feignclients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OpenFeign client to consume the pokeapi/species API.
 */
@FeignClient(url = "${feign.clients.species.url}", name = "${feign.clients.species.name}")

public interface SpeciesClient {
    /**
     * Gets a JSON string with the pokemon species information given a name.
     * @param name
     * @return {@link String}
     */
    @CircuitBreaker(name = "species-client", fallbackMethod = "getSpeciesFallback")
    @GetMapping(value = "${feign.clients.species.resource}")
    String getSpeciesData(@PathVariable("name") String name);

    default String getSpeciesFallback(String name, Throwable error){
        return Strings.EMPTY;
    }
}
