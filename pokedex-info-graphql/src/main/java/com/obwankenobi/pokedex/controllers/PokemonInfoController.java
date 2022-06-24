package com.obwankenobi.pokedex.controllers;

import com.obwankenobi.pokedex.model.Response;
import com.obwankenobi.pokedex.model.pokemonInfo.request.PokemonInfoRequest;
import com.obwankenobi.pokedex.services.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonInfoController {
    @Autowired
    private PokemonInfoService pokemonInfoService;

    @GetMapping("${services.pokemon-info.mainPath}")
    public ResponseEntity<Response> pokemonInfo(@RequestBody PokemonInfoRequest request){
        return ResponseEntity.ok(pokemonInfoService.pokemonInfo(request));
    }
}
