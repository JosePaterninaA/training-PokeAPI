package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class that contains a DescriptionItem to PokemonInfoClass
 */
@Data
@AllArgsConstructor
public class DescriptionItem {
    private String descriptionText;
    private String gameVersion;
    private String languageCode;
}
