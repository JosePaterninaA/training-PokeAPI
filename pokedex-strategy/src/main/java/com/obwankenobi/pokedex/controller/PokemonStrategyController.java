package com.obwankenobi.pokedex.controller;

import com.obwankenobi.pokedex.model.PokemonStrategy;
import com.obwankenobi.pokedex.model.StrategyRequest;
import com.obwankenobi.pokedex.services.PokemonStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonStrategyController {

    @Autowired
    PokemonStrategyService pokemonStrategyService;

    @PostMapping("${services.pokemon-strategy.main-path}")
    public ResponseEntity<PokemonStrategy> pokemonStrategyResponseEntity(@RequestBody StrategyRequest strategyRequest){
        return ResponseEntity.ok(pokemonStrategyService.getPokemonStrategyByName(strategyRequest.getName()));
    }
}
