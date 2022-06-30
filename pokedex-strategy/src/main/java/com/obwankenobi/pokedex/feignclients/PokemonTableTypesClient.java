package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.StrategyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${feign.clients.info.url}", name = "${feign.clients.info.name}")
public interface PokemonTableTypesClient {

    @RequestMapping(value = "${feign.clients.info.resource}", method = RequestMethod.GET)
    public PokemonTableTypes getPokemonTableTypes(@RequestBody StrategyRequest type);
}
