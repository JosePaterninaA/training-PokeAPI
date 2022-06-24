package com.obwankenobi.pokedex.graphqlClients.impl;

import com.obwankenobi.pokedex.graphqlClients.GraphqlRequestBody;
import com.obwankenobi.pokedex.graphqlClients.PokemonInfoGraphQLClient;
import com.obwankenobi.pokedex.model.Request;
import com.obwankenobi.pokedex.model.pokemonInfo.request.PokemonInfoRequest;
import com.obwankenobi.pokedex.model.pokemonInfo.response.PokemonInfoResponse;
import com.obwankenobi.pokedex.util.GraphqlSchemaReaderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class PokeapiClient implements PokemonInfoGraphQLClient {

    @Value("${graphql.url.pokemon-info}")
    private String url;

    @Override
    public PokemonInfoResponse pokemonInfoResponse(Request request) {
        WebClient webClient = WebClient.builder().build();

        GraphqlRequestBody graphQLRequestBody = new GraphqlRequestBody();

        final String query;

        try {
            query = GraphqlSchemaReaderUtil.getSchemaFromFileName("pokemon-info-query");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String pokemonName = ((PokemonInfoRequest) request).getName();

        graphQLRequestBody.setQuery(query.replace("pokemonName", pokemonName));

        return webClient.post()
                .uri(url)
                .bodyValue(graphQLRequestBody)
                .retrieve()
                .bodyToMono(PokemonInfoResponse.class)
                .block();
    }
}
