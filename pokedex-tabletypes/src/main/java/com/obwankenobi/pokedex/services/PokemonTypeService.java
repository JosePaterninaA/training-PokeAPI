package com.obwankenobi.pokedex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import com.obwankenobi.pokedex.feignclients.PokemonTypeClient;
import com.obwankenobi.pokedex.model.PokemonType;
import com.obwankenobi.pokedex.services.mappers.PokemonTypeMapper;

@Service
public class PokemonTypeService {

	@Autowired
	PokemonTypeClient typeClient;
	@Autowired
	PokemonTypeMapper pokemonTypeMapper;

	public PokemonType getPokemonTypeByName(String name) throws Exception {

		String pokemonTypeData;
		try {
			pokemonTypeData = typeClient.getPokemonData(name);
		} catch (Exception e) {
			throw new PokemonException(e.getMessage());
		}
		return pokemonTypeMapper.getPokemonTypeInfo(pokemonTypeData);
	}
}
