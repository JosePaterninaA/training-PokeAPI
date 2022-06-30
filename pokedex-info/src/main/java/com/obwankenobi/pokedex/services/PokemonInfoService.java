package com.obwankenobi.pokedex.services;

import com.obwankenobi.pokedex.exceptions.PokemonInfoException;
import com.obwankenobi.pokedex.feignclients.SpeciesClient;
import com.obwankenobi.pokedex.services.mappers.PokemonInfoStringMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obwankenobi.pokedex.feignclients.PokemonClient;
import com.obwankenobi.pokedex.model.PokemonInfo;

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
	 * @throws PokemonInfoException
	 */
	public PokemonInfo getPokemonInfoByName (String name) throws PokemonInfoException {

		try{
			String pokemonTypeData = pokemonClient.getPokemonData(name);
			String pokemonDescriptionData = speciesClient.getSpeciesData(name);

			return pokemonInfoStringMapper.mapJSONStringToPokemonInfo(pokemonTypeData, pokemonDescriptionData);
		}catch (PokemonInfoException | FeignException.FeignClientException e){
			throw new PokemonInfoException(e.getMessage(), e);
		}
	}
}
