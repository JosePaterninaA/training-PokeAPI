package com.obwankenobi.pokedex.services;

import com.obwankenobi.pokedex.feignclients.SpeciesClient;
import com.obwankenobi.pokedex.services.mappers.PokemonInfoStringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonClient;
import com.obwankenobi.pokedex.model.PokemonInfo;

@Service
public class PokemonInfoService {

	@Autowired
	PokemonClient pokemonClient;

	@Autowired
	SpeciesClient speciesClient;
	@Autowired
	PokemonInfoStringMapper pokemonInfoStringMapper;

	public PokemonInfo getPokemonInfoByName (String name) {

		String pokemonTypeData = pokemonClient.getPokemonData(name);
		String pokemonDescriptionData = speciesClient.getSpeciesData(name);

		return pokemonInfoStringMapper.mapJSONStringToPokemonInfo(pokemonTypeData, pokemonDescriptionData);
	}
}
