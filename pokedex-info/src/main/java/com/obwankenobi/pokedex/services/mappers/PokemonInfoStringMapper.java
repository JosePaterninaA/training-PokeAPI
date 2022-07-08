package com.obwankenobi.pokedex.services.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.obwankenobi.pokedex.config.exceptions.InvalidPokemonJsonFormat;
import com.obwankenobi.pokedex.model.DescriptionItem;
import com.obwankenobi.pokedex.model.PokemonInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Deserializa JSON strings para obtener datos específicos.
 */
@Component
public class PokemonInfoStringMapper {

    private static final String ID_FIELD = "id";
    private static final String NAME_FIELD = "name";
    private static final String TYPE_FIELD = "type";
    private static final String TYPE_CONTAINER_FIELD = "types";
    private static final String VERSION_FIELD = "version";
    private static final String DESCRIPTION_FIELD = "flavor_text";
    private static final String DESCRIPTION_CONTAINER_FIELD = "flavor_text_entries";
    private static final String LANGUAGE_FIELD = "language";
    private static final String ENGLISH = "en";

    /**
     * Deserializa JSON strings con información sobre el tipo y descripción en un objeto del tipo {@link PokemonInfo}
     * @param typeData
     * @param descriptionData
     * @return {@link PokemonInfo}
     * @throws InvalidPokemonJsonFormat
     */
    public PokemonInfo mapJSONStringToPokemonInfo(String typeData, String descriptionData) throws InvalidPokemonJsonFormat {

        if(Strings.isNullOrEmpty(typeData) || Strings.isNullOrEmpty(descriptionData)){
            throw new InvalidPokemonJsonFormat("No empty data allowed.");
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Nodo que contiene la lista de tipos
            JsonNode typesNode = objectMapper.readTree(typeData);

            // Nodo que contiene de DescriptionItems
            JsonNode descriptionNode = objectMapper.readTree(descriptionData);

            return PokemonInfo.builder()
                    .id(typesNode.get(ID_FIELD).asText())
                    .name(typesNode.get(NAME_FIELD).asText())
                    .types(getTypesList(typesNode))
                    .descriptionItems(getDescriptionList(descriptionNode))
                    .build();

        }catch (NullPointerException | JsonProcessingException e){
            throw new InvalidPokemonJsonFormat(e.getMessage(), e);
        }
    }

    /**
     * Get list of types in the given JSON node
     * @param typesNode
     * @return
     */
    private List<String> getTypesList(JsonNode typesNode){
        JsonNode typesJson = typesNode.get(TYPE_CONTAINER_FIELD);
        Stream<JsonNode> typesStream = StreamSupport.stream(typesJson.spliterator(), false);
        return typesStream.map(node -> node.get(TYPE_FIELD).get(NAME_FIELD).asText()).collect(Collectors.toList());
    }

    /**
     * Get list of description items in the given JSON node
     * @param descriptionNode
     * @return
     */
    private List<DescriptionItem> getDescriptionList(JsonNode descriptionNode){
        JsonNode descriptionJson = descriptionNode.get(DESCRIPTION_CONTAINER_FIELD);
        Stream<JsonNode> descriptionItemStream = StreamSupport.stream(descriptionJson.spliterator(), false);
        return descriptionItemStream
                .map(node -> new DescriptionItem(
                        node.get(DESCRIPTION_FIELD).asText(),
                        node.get(VERSION_FIELD).get(NAME_FIELD).asText(),
                        node.get(LANGUAGE_FIELD).get(NAME_FIELD).asText()))
                .filter(node -> node.getLanguageCode().equalsIgnoreCase(ENGLISH))
                .collect(Collectors.toList());
    }
}
