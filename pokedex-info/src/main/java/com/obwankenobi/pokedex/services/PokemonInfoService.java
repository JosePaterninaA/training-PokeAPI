package com.obwankenobi.pokedex.services;

import com.google.common.base.Strings;
import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import com.obwankenobi.pokedex.feignclients.SpeciesClient;
import com.obwankenobi.pokedex.services.mappers.PokemonInfoStringMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonClient;
import com.obwankenobi.pokedex.model.PokemonInfo;


/**
 * Used to build a PokemonInfo response.
 */
@Service
public class PokemonInfoService {

	private static final String POKEMON_INFO_SERVICE_NULL_NAME_EXCEPTION_MESSAGE = "Name must not be null";

	@Autowired
	PokemonClient pokemonClient;
	@Autowired
	SpeciesClient speciesClient;
	@Autowired
	PokemonInfoStringMapper pokemonInfoStringMapper;

	/**
	 * Given a name it builds a {@link PokemonInfo} by using data from {@link PokemonClient} and {@link SpeciesClient}.
	 * @param name
	 * @return {@link PokemonInfo}
	 * @throws
	 */
	public PokemonInfo getPokemonInfoByName (String name) throws FeignException, PokemonException {

		if(Strings.isNullOrEmpty(name)) throw new PokemonException(POKEMON_INFO_SERVICE_NULL_NAME_EXCEPTION_MESSAGE);

		name = name.toLowerCase();

		String pokemonTypeData = pokemonClient.getPokemonData(name);
		String pokemonDescriptionData = speciesClient.getSpeciesData(name);

		return pokemonInfoStringMapper.mapJSONStringToPokemonInfo(pokemonTypeData, pokemonDescriptionData);
	}
}
