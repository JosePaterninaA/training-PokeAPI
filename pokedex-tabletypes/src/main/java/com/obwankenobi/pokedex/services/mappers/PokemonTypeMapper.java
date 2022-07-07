package com.obwankenobi.pokedex.services.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obwankenobi.pokedex.model.PokemonType;
import com.obwankenobi.pokedex.model.Weakness;

/**
 * This class manage the mapping data from string json response into a class {@Link PokemonType}
 * @author nathaly.salamanca
 *
 */
@Component
public class PokemonTypeMapper {
	
	private static final String NAME_FIELD ="name";
	private static final String DAMAGE_LIST_FIELD ="damage_relations";
	private static final String DOUBLE_DAMAGE_FIELD = "double_damage_from";
	private static final String HALF_DAMAGE_FIELD = "half_damage_from";
	private static final String NO_DAMAGE_FIELD = "no_damage_from";
	private static final String ID_FIELD="id";
	private static final String DOUBLE_LABEL = "Double";
	private static final String HALF_LABEL = "Half";
	private static final String NO_LABEL = "No";

	/**
	 * 
	 * @param data json to get pokemon type data and wicknesses
	 * @return pokemon type data {@link PokemonType}
	 * @throws JsonProcessingException
	 */
	public PokemonType getPokemonTypeInfo(String data) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		List<Weakness> weaknesses = new ArrayList<>();

		JsonNode typeNode = mapper.readTree(data);
		JsonNode weaknessesJson = typeNode.get(DAMAGE_LIST_FIELD);
			
		weaknesses.addAll(getDamageList(weaknessesJson, DOUBLE_DAMAGE_FIELD, DOUBLE_LABEL ));
		weaknesses.addAll(getDamageList(weaknessesJson, HALF_DAMAGE_FIELD, HALF_LABEL));
		weaknesses.addAll(getDamageList(weaknessesJson, NO_DAMAGE_FIELD, NO_LABEL));				 

			
		return PokemonType.builder()
				.id(typeNode.get(ID_FIELD).asText())
				.name(typeNode.get(NAME_FIELD).asText())
				.weaknesses(weaknesses)
				.build();
	
	}
	/**
	 * this method manages the extraction of weaknesses data
	 * @param typeNode json node to get data
	 * @param damageLevel kind of pokemon damage to chose list to extract data
	 * @param damageValue label with the name of damage level 
	 * @return List of weaknesses {@link Weakness}
	 */
	private List<Weakness> getDamageList(JsonNode typeNode, String damageLevel,String damageValue) {
		
		JsonNode weaknessNode = typeNode.get(damageLevel);
		Stream<JsonNode> weaknessesStream = StreamSupport.stream(weaknessNode.spliterator(), false);
		
		return weaknessesStream
				.map(node -> new Weakness(
					node.get(NAME_FIELD).asText(),
					damageValue))
				.collect(Collectors.toList());
	}

}
