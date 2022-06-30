package com.obwankenobi.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data que representa una descripción de un pokemon.
 */
@Data
@AllArgsConstructor
public class DescriptionItem {

	private String descriptionText;
	private String gameVersion;
	private String languageCode;

}
