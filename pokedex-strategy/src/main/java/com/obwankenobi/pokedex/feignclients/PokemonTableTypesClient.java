package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.StrategyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Interface to establish connection with pokemon-tabletypes service
 */
@FeignClient("${feign.clients.type.name}")
public interface PokemonTableTypesClient {

    /**
     * Method to get a PokemonTableTypes object by making a request to pokemon-tabletypes service
     * @param type
     * @return
     */
    @PostMapping(value = "${feign.clients.type.resource}")
    PokemonTableTypes getPokemonTableTypes(@RequestBody StrategyRequest type);
}
