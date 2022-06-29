package com.obwankenobi.pokedex.controller;

import com.obwankenobi.pokedex.exceptions.PokemonInfoException;
import com.obwankenobi.pokedex.model.PokemonInfo;
import com.obwankenobi.pokedex.model.PokemonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obwankenobi.pokedex.services.PokemonInfoService;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PokemonInfoController {

	@Autowired
	PokemonInfoService pokemonInfoService;
	
	@GetMapping("${services.pokemon-info.main-path}")
	public ResponseEntity<PokemonInfo> pokemonInfo(@RequestBody PokemonRequest request){
		try{
			return ResponseEntity.ok(pokemonInfoService.getPokemonInfoByName(request.getName()));
		}catch (PokemonInfoException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
