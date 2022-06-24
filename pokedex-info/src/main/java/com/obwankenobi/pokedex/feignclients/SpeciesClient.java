package com.obwankenobi.pokedex.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "https://pokeapi.co", name = "species-client")

public interface SpeciesClient {
    @RequestMapping(value = "/api/v2/pokemon-species/{name}/", method = RequestMethod.GET)
    public String getSpeciesData(@PathVariable("name") String name);
}
