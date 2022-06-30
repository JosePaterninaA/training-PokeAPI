package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.StrategyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("${feign.clients.type.name}")
public interface PokemonTableTypesClient {

    @PostMapping(value = "${feign.clients.type.resource}")
    public PokemonTableTypes getPokemonTableTypes(@RequestBody StrategyRequest type);
}
