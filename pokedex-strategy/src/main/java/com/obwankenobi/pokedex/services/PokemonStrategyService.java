package com.obwankenobi.pokedex.services;

import com.google.common.base.Strings;
import com.obwankenobi.pokedex.config.exceptions.PokemonException;
import com.obwankenobi.pokedex.feignclients.PokemonInfoClient;
import com.obwankenobi.pokedex.feignclients.PokemonTableTypesClient;
import com.obwankenobi.pokedex.feignclients.model.PokemonInfo;
import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.PokemonStrategy;
import com.obwankenobi.pokedex.model.StrategyRequest;
import com.obwankenobi.pokedex.model.TypeWeaknesses;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service of PokemonStrategy
 */
@Service
public class PokemonStrategyService {

    @Autowired
    PokemonInfoClient pokemonInfoClient;

    @Autowired
    PokemonTableTypesClient pokemonTableTypesClient;

    /**
     * method that returns a PokemonStrategy instance from PokemonInfo and PokemonTableTypes instances
     * @param name
     * @return
     * @throws FeignException
     */
    public PokemonStrategy getPokemonStrategyByName (String name) throws FeignException, PokemonException {

        if(Strings.isNullOrEmpty(name)) throw new PokemonException("Name must not be null.");

        name = name.toLowerCase();
        PokemonInfo pokemonInfo = pokemonInfoClient.getPokemonInfo(new StrategyRequest(name));

        List<String> pokemonTypesList = pokemonInfo.getTypes();

        if(pokemonTypesList == null) throw new PokemonException("Name is not valid.");

        List<TypeWeaknesses> weaknessesList = pokemonTypesList.stream().map( type -> {
           PokemonTableTypes pokemonTableTypes = pokemonTableTypesClient.getPokemonTableTypes(new StrategyRequest(type));
            return new TypeWeaknesses(type, pokemonTableTypes.getWeaknesses() );
        }).collect(Collectors.toList());

        return new PokemonStrategy(pokemonInfo.getId(), pokemonInfo.getName(), weaknessesList);
    }
}
