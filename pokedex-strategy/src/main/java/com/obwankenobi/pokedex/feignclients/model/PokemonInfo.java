package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PokemonInfo {
    private String id;
    private String name;
    private List<String> types;
    private List<DescriptionItem> descriptionItems;
}
