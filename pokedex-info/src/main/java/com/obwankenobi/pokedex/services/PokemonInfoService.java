package com.obwankenobi.pokedex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonClient;
import com.obwankenobi.pokedex.model.PokemonInfo;

@Service
public class PokemonInfoService {

	public String getPokemonInfoByName (String name) {
		return pokemonClient.getPokemonData(name);
	}
	
	@Autowired
	PokemonClient pokemonClient;
}
