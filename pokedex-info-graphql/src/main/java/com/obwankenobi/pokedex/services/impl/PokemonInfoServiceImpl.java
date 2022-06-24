package com.obwankenobi.pokedex.services.impl;

import com.obwankenobi.pokedex.graphqlClients.PokemonInfoGraphQLClient;
import com.obwankenobi.pokedex.model.Request;
import com.obwankenobi.pokedex.model.pokemonInfo.request.PokemonInfoRequest;
import com.obwankenobi.pokedex.model.pokemonInfo.response.PokemonInfoResponse;
import com.obwankenobi.pokedex.services.PokemonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PokemonInfoServiceImpl implements PokemonInfoService {

    @Autowired
    private PokemonInfoGraphQLClient pokemonInfoGraphQLClient;

    @Override
    public PokemonInfoResponse pokemonInfo(Request request) {
        PokemonInfoResponse response = (PokemonInfoResponse) pokemonInfoGraphQLClient.pokemonInfoResponse(request);
        return response;
    }
}
