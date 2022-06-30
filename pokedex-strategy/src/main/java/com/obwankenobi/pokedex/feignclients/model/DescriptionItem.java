package com.obwankenobi.pokedex.feignclients.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DescriptionItem {
    private String descriptionText;
    private String gameVersion;
    private String languageCode;
}
