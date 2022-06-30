package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente openfeign que consume la API pokeapi/species
 */
@FeignClient(url = "${feign.clients.species.url}", name = "${feign.clients.species.name}")

public interface SpeciesClient {
    /**
     * Obtiene JSON string con información sobre la especie dado un nombre
     * @param name
     * @return {@link String}
     */
    @GetMapping(value = "${feign.clients.species.resource}")
    String getSpeciesData(@PathVariable("name") String name);
}
