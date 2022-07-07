package com.obwankenobi.pokedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obwankenobi.pokedex.model.PokemonRequest;
import com.obwankenobi.pokedex.model.PokemonType;
import com.obwankenobi.pokedex.services.PokemonTypeService;

/**
 * 
 * Controller of pokemontype APIs
 * @author nathaly.salamanca
 *
 */
@RestController
public class PokemonTypeController {
	

	@Autowired
	PokemonTypeService pokemonTypeService;
	
	/**
	 * This method get the pokemon type information given  a pokemon name 
	 * @param request {@link PokemonRequest}
	 * @return {@link ResponseEntity}
	 * @throws Exception
	 */
	@PostMapping("${services.pokemon-type.main-path}")
	public ResponseEntity<PokemonType> pokemonTypeInfo(@RequestBody PokemonRequest request) throws Exception{
		
			return ResponseEntity.ok(pokemonTypeService.getPokemonTypeByName(request.getName()));
	}
}
