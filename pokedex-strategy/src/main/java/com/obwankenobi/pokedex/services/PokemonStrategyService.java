package com.obwankenobi.pokedex.services;

import com.obwankenobi.pokedex.feignclients.PokemonInfoClient;
import com.obwankenobi.pokedex.feignclients.PokemonTableTypesClient;
import com.obwankenobi.pokedex.feignclients.model.PokemonInfo;
import com.obwankenobi.pokedex.feignclients.model.PokemonTableTypes;
import com.obwankenobi.pokedex.model.PokemonStrategy;
import com.obwankenobi.pokedex.model.StrategyRequest;
import com.obwankenobi.pokedex.model.TypeWeaknesses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonStrategyService {

    @Autowired
    PokemonInfoClient pokemonInfoClient;

    @Autowired
    PokemonTableTypesClient pokemonTableTypesClient;

//    @Autowired
//    PokemonTableTypes pokemonTableTypes;


    public PokemonStrategy getPokemonStrategyByName (String name) {


        PokemonInfo pokemonInfo = pokemonInfoClient.getPokemonInfo(new StrategyRequest(name));

        List<String> pokemonTypesList = pokemonInfo.getTypes();
        PokemonTableTypes pokemonTableTypes1 = pokemonTableTypesClient.getPokemonTableTypes(new StrategyRequest("electric"));
        List<TypeWeaknesses> weaknessesList = pokemonTypesList.stream().map( type -> {
           PokemonTableTypes pokemonTableTypes = pokemonTableTypesClient.getPokemonTableTypes(new StrategyRequest(type));
            return new TypeWeaknesses(type, pokemonTableTypes.getWeaknesses() );
        }).collect(Collectors.toList());

        PokemonStrategy pokemonStrategyResponse = new PokemonStrategy(pokemonInfo.getId(), pokemonInfo.getName(), weaknessesList);

        return pokemonStrategyResponse;
    }
}
