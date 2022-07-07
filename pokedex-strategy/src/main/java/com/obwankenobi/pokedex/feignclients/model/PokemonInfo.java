package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Class that contains the properties id, name, types lists of types and descriptionItem
 */
@Data
@AllArgsConstructor
public class PokemonInfo {
    private String id;
    private String name;
    private List<String> types;
    private List<DescriptionItem> descriptionItems;
}
