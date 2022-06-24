package com.obwankenobi.pokedex.controller;

import com.obwankenobi.pokedex.model.PokemonInfo;
import com.obwankenobi.pokedex.model.PokemonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obwankenobi.pokedex.services.PokemonInfoService;

@RestController
public class PokemonInfoController {

	@Autowired
	PokemonInfoService pokemonInfoService;
	
	@GetMapping("/api/pokedex/info")
	public ResponseEntity<PokemonInfo> pokemonInfo(@RequestBody PokemonRequest request){
		return ResponseEntity.ok(pokemonInfoService.getPokemonInfoByName(request.getName()));
	}
}
