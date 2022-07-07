package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonInfo {
    private String id;
    private String name;
    private List<String> types;
    private List<DescriptionItem> descriptionItems;
}
