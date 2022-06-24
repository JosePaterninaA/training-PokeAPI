package com.obwankenobi.pokedex.services;

import com.obwankenobi.pokedex.feignclients.SpeciesClient;
import com.obwankenobi.pokedex.services.mappers.PokemonInfoStringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonClient;
import com.obwankenobi.pokedex.model.PokemonInfo;

@Service
public class PokemonInfoService {

	public PokemonInfo getPokemonInfoByName (String name) {

		String pokemonTypeData = pokemonClient.getPokemonData(name);
		String pokemonDescriptionData = speciesClient.getSpeciesData(name);

		PokemonInfo response = PokemonInfoStringMapper.mapStringToPokemonInfo(pokemonTypeData, pokemonDescriptionData);
		return response;
	}
	
	@Autowired
	PokemonClient pokemonClient;

	@Autowired
	SpeciesClient speciesClient;
}
