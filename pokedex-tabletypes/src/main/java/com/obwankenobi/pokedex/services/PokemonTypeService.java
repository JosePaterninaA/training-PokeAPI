package com.obwankenobi.pokedex.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Strings;
import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonTypeClient;
import com.obwankenobi.pokedex.model.PokemonType;
import com.obwankenobi.pokedex.services.mappers.PokemonTypeMapper;

@Service
public class PokemonTypeService {

	@Autowired
	PokemonTypeClient typeClient;
	@Autowired
	PokemonTypeMapper pokemonTypeMapper;

	public PokemonType getPokemonTypeByName(String name) throws FeignException, PokemonException {

		if(Strings.isNullOrEmpty(name)) throw new PokemonException("Name must not be null.");

		String pokemonTypeData;
		pokemonTypeData = typeClient.getPokemonData(name);

		return pokemonTypeMapper.getPokemonTypeInfo(pokemonTypeData);
	}
}
