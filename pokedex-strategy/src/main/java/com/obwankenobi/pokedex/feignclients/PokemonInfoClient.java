package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonInfo;
import com.obwankenobi.pokedex.model.StrategyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("${feign.clients.info.name}")
public interface PokemonInfoClient {

    @PostMapping(value = "${feign.clients.info.resource}")
    public PokemonInfo getPokemonInfo(@RequestBody StrategyRequest strategyRequest);
}
