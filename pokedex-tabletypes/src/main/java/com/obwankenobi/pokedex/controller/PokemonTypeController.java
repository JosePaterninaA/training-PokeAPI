package com.obwankenobi.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obwankenobi.pokedex.model.PokemonRequest;
import com.obwankenobi.pokedex.model.PokemonType;
import com.obwankenobi.pokedex.services.PokemonTypeService;

@RestController
public class PokemonTypeController {

	@Autowired
	PokemonTypeService pokemonTypeService;
	
	@GetMapping("${services.pokemon-type.main-path}")
	public ResponseEntity<PokemonType> pokemonTypeInfo(@RequestBody PokemonRequest request) throws Exception{
		
			return ResponseEntity.ok(pokemonTypeService.getPokemonTypeByName(request.getName()));
	}
}
