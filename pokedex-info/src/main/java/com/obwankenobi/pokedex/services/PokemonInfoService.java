package com.obwankenobi.pokedex.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import com.obwankenobi.pokedex.feignclients.SpeciesClient;
import com.obwankenobi.pokedex.services.mappers.PokemonInfoStringMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonClient;
import com.obwankenobi.pokedex.model.PokemonInfo;

import java.util.Locale;

/**
 * Data usada como response body en las implementaciones de la API.
 */
@Service
public class PokemonInfoService {

	@Autowired
	PokemonClient pokemonClient;
	@Autowired
	SpeciesClient speciesClient;
	@Autowired
	PokemonInfoStringMapper pokemonInfoStringMapper;

	/**
	 * Dado un nombre crea un {@link PokemonInfo} consolidando datos de {@link PokemonClient} y {@link SpeciesClient}
	 * @param name
	 * @return {@link PokemonInfo}
	 * @throws {@link FeignException}, {@link PokemonException}
	 */
	public PokemonInfo getPokemonInfoByName (String name) throws FeignException, PokemonException {

		if(name == null) throw new PokemonException("Name must not be null.");

		name = name.toLowerCase();

		String pokemonTypeData = pokemonClient.getPokemonData(name);
		String pokemonDescriptionData = speciesClient.getSpeciesData(name);

		return pokemonInfoStringMapper.mapJSONStringToPokemonInfo(pokemonTypeData, pokemonDescriptionData);
	}
}
