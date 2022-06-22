package com.obwankenobi.pokedex.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonInfo {

	private String id;
	private String name;
	private List<String> types;
	private List<DescriptionItem> descriptionItems;
}
