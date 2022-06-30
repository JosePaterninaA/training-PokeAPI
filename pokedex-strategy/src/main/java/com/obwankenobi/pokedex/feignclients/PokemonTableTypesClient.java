package com.obwankenobi.pokedex.feignclients;

import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.StrategyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8082", name = "pokemon-table-types")
public interface PokemonTableTypesClient {

    @RequestMapping(value = "/api/pokedex/tableTypes", method = RequestMethod.GET)
    public PokemonTableTypes getPokemonTableTypes(@RequestBody StrategyRequest type);
}
