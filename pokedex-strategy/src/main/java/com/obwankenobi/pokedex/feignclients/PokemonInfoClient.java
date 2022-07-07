package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonInfo;
import com.obwankenobi.pokedex.model.StrategyRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("${feign.clients.info.name}")
public interface PokemonInfoClient {

    @CircuitBreaker(name = "pokemon-info-client", fallbackMethod = "getPokemonInfoFallback")
    @PostMapping(value = "${feign.clients.info.resource}")
    PokemonInfo getPokemonInfo(@RequestBody StrategyRequest strategyRequest);

    default PokemonInfo getPokemonInfoFallback(StrategyRequest strategyRequest, Throwable error){
        return new PokemonInfo();
    }
}
