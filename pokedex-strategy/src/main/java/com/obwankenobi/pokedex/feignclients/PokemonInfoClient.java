package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonInfo;
import com.obwankenobi.pokedex.model.StrategyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8082", name = "pokemon-info-client")
public interface PokemonInfoClient {

    @PostMapping(value = "/api/pokedex/info")
    public PokemonInfo getPokemonInfo(@RequestBody StrategyRequest strategyRequest);
}
