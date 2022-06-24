package com.obwankenobi.pokedex.services.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obwankenobi.pokedex.model.DescriptionItem;
import com.obwankenobi.pokedex.model.PokemonInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PokemonInfoStringMapper {

    public static PokemonInfo mapStringToPokemonInfo(String typeData, String descriptionData){

        ObjectMapper objectMapper = new ObjectMapper();
        PokemonInfo pokemonInfo = null;
        JsonNode typesNode = null;
        JsonNode descriptionNode = null;

        try {
            typesNode = objectMapper.readTree(typeData);
            descriptionNode = objectMapper.readTree(descriptionData);

            PokemonInfo.PokemonInfoBuilder pokemonInfoBuilder = PokemonInfo.builder();
            pokemonInfoBuilder
                    .id(typesNode.get("id").asText())
                    .name(typesNode.get("name").asText());

            JsonNode typesJson = typesNode.get("types");
            JsonNode descriptionJson = descriptionNode.get("flavor_text_entries");

            Iterable<JsonNode> typesIterable = () -> typesJson.iterator();
            Stream<JsonNode> typesStream = StreamSupport.stream(typesIterable.spliterator(), false);
            List<String> types = typesStream.map((node)->node.get("type").get("name").asText()).collect(Collectors.toList());

            Iterable<JsonNode> descriptionIterable = () -> descriptionJson.iterator();
            Stream<JsonNode> descriptionItemStream = StreamSupport.stream(descriptionIterable.spliterator(), false);
            List<DescriptionItem> descriptionItems = descriptionItemStream
                    .map((node)-> new DescriptionItem(
                        node.get("flavor_text").asText(),
                        node.get("version").get("name").asText(),
                        node.get("language").get("name").asText()))
                    .filter((node)->node.getLanguageCode().equalsIgnoreCase("en"))
                    .collect(Collectors.toList());

            pokemonInfoBuilder
                    .types(types)
                    .descriptionItems(descriptionItems);

            pokemonInfo = pokemonInfoBuilder.build();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return pokemonInfo;
    }
}
