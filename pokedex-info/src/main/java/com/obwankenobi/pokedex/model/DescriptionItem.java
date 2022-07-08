package com.obwankenobi.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data representing a Pokemon description item.
 */
@Data
@AllArgsConstructor
public class DescriptionItem {

	private String descriptionText;
	private String gameVersion;
	private String languageCode;

}
