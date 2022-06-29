package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${feign.clients.species.url}", name = "${feign.clients.species.name}")

public interface SpeciesClient {
    @GetMapping(value = "${feign.clients.species.resource}")
    String getSpeciesData(@PathVariable("name") String name);
}
