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

import java.util.Locale;

/**
 * This class provides the services related to pokemon type 
 * @author nathaly.salamanca
 *
 */
@Service
public class PokemonTypeService {

	@Autowired
	PokemonTypeClient typeClient;
	@Autowired
	PokemonTypeMapper pokemonTypeMapper;
	
	/**
	 * This method invokes the feing service {@link PokemonTypeClient#getPokemonData(String)} 
	 * their response is the param of {@link PokemonTypeMapper #getPokemonTypeByName(String)}  
	 * @param name pokemon name 
	 * @return pokemon type information {@link PokemonType}
	 * @throws FeignException
	 * @throws JsonProcessingException
	 */
	public PokemonType getPokemonTypeByName(String name) throws FeignException, PokemonException {

		if(Strings.isNullOrEmpty(name)) throw new PokemonException("Name must not be null.");

		name = name.toLowerCase();

		String pokemonTypeData;
		pokemonTypeData = typeClient.getPokemonData(name);

		if(Strings.isNullOrEmpty(pokemonTypeData)) throw new PokemonException("Name is not valid.");

		return pokemonTypeMapper.getPokemonTypeInfo(pokemonTypeData);
	}
}
