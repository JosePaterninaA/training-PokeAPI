package com.obwankenobi.pokedex.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PokemonInfo {

	private String id;
	private String name;
	private List<String> types;
	private List<DescriptionItem> descriptionItems;
}
