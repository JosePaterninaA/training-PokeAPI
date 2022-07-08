package com.obwankenobi.pokedex.controller;

import com.obwankenobi.pokedex.model.PokemonInfo;
import com.obwankenobi.pokedex.model.PokemonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.obwankenobi.pokedex.services.PokemonInfoService;

/**
 * Controller to expose APIs
 */
@RestController
public class PokemonInfoController {

	@Autowired
	PokemonInfoService pokemonInfoService;

	/**
	 * API that provides types and descriptions of a Pokemon given its name.
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("${services.pokemon-info.main-path}")
	public ResponseEntity<PokemonInfo> pokemonInfo(@RequestBody PokemonRequest request) throws Exception{
		return ResponseEntity.ok(pokemonInfoService.getPokemonInfoByName(request.getName()));
	}
}
